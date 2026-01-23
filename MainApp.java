package module5.activity3;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("===== STUDENT COURSE MANAGEMENT =====");
			System.out.println("1. Add Student");
			System.out.println("2. Add Course");
			System.out.println("3. Show Students");
			System.out.println("4. Show Courses");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addStudent(sc);
				break;
			case 2:
				addCourse(sc);
				break;
			case 3:
				showStudents();
				break;
			case 4:
				showCourses();
				break;
			case 0:
				System.out.println("Exiting application. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}

		} while (choice != 0);
	}

	private static void addStudent(Scanner sc) {
		try (Connection conn = DBConnection.getConnection()) {
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Age: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();

			PreparedStatement ps = conn.prepareStatement("INSERT INTO students (name, age, email) VALUES (?, ?, ?)");
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, email);
			ps.executeUpdate();
			System.out.println("Student added successfully!");
		} catch (Exception e) {
			System.out.println("Error adding student: " + e.getMessage());
		}
	}

	private static void addCourse(Scanner sc) {
		try (Connection conn = DBConnection.getConnection()) {
			System.out.print("Course Name: ");
			String courseName = sc.nextLine();
			System.out.print("Grade: ");
			double grade = sc.nextDouble();
			System.out.print("Student ID: ");
			int studentId = sc.nextInt();
			sc.nextLine();

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO courses (course_name, grade, student_id) VALUES (?, ?, ?)");
			ps.setString(1, courseName);
			ps.setDouble(2, grade);
			ps.setInt(3, studentId);
			ps.executeUpdate();
			System.out.println("Course added successfully!");
		} catch (Exception e) {
			System.out.println("Error adding course: " + e.getMessage());
		}
	}

	private static void showStudents() {
		try (Connection conn = DBConnection.getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
			System.out.println("ID | Name           | Age | Email");
			System.out.println("-----------------------------------------");
			while (rs.next()) {
				System.out.printf("%d | %-14s | %d | %s%n", rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("Error displaying students: " + e.getMessage());
		}
	}

	private static void showCourses() {
		try (Connection conn = DBConnection.getConnection()) {
			ResultSet rs = conn.createStatement()
					.executeQuery("SELECT c.id, c.course_name, c.grade, s.name AS student_name "
							+ "FROM courses c JOIN students s ON c.student_id = s.id");
			System.out.println("ID | Course Name | Grade | Student Name");
			System.out.println("---------------------------------------");
			while (rs.next()) {
				System.out.printf("%d | %-12s | %.1f | %s%n", rs.getInt("id"), rs.getString("course_name"),
						rs.getDouble("grade"), rs.getString("student_name"));
			}
		} catch (Exception e) {
			System.out.println("Error displaying courses: " + e.getMessage());
		}
	}
}
