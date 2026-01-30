package com.bpi.m6act5;

import jakarta.persistence.EntityManager;
import java.util.List;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		int studentIdSearch = 3;
		int ageSearch = 25;
		try {

			List<String> names = findStudentNames(em);
			System.out.println("All student names:");
			names.forEach(System.out::println);

			Long courseCount = countCoursesByStudentId(em, 1);
			System.out.println("Courses for Student ID " + studentIdSearch + ": " + courseCount);

			Long olderStudents = findStudentsByAgeGreaterThan(em, 30);
			System.out.println("Students older than " + ageSearch + ": " + olderStudents);

		} finally {
			em.close();
		}
	}

	public static List<String> findStudentNames(EntityManager em) {
		return em.createQuery("SELECT s.name FROM Student s", String.class).getResultList();
	}

	public static Long countCoursesByStudentId(EntityManager em, int id) {
		return em.createQuery("SELECT COUNT(c) FROM Course c WHERE c.student.id = ?1", Long.class).setParameter(1, id)
				.getSingleResult();
	}

	public static Long findStudentsByAgeGreaterThan(EntityManager em, int age) {
		return em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.age > ?1", Long.class).setParameter(1, age)
				.getSingleResult();
	}
}
