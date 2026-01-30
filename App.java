package com.bpi.m6act4;

import jakarta.persistence.EntityManager;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			m6Activity4Solution(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void m6Activity4Solution(EntityManager em) {
		em.getTransaction().begin();

		Student newStudent = new Student("Juan Cruz", 22, "juancruz@example.com");
		em.persist(newStudent);
		em.flush();
		em.detach(newStudent);
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

		newStudent = em.merge(newStudent);
		em.flush();
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

		newStudent.setAge(23);
		newStudent.setEmail("juancrus@example.com");
		em.flush();
		em.detach(newStudent);
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

		newStudent = em.merge(newStudent);
		em.remove(newStudent);
		em.flush();
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

		em.getTransaction().commit();
	}
}
