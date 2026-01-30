package com.bpi.m6act3;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "course_name", length = 50)
	private String courseName;

	@Column(name = "grade", length = 2)
	private String grade;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false) // foreign key column
	private Student student;

	public Course() {
	}

	public Course(String courseName, String grade, Student student) {
		this.courseName = courseName;
		this.grade = grade;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}