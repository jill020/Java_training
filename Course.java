package module5.activity3;

public class Course {
	private int id;
	private String courseName;
	private double grade;
	private int studentId;

	public Course(String courseName, double grade, int studentId) {
		this.courseName = courseName;
		this.grade = grade;
		this.studentId = studentId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
