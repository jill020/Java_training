package com.bpi.m6act2;

import jakarta.persistence.EntityManager;

public class App {
	 
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
 
		try {
			runM6Activity2(em);
				} finally {
					EntityManagerUtil.getInstance().closeEntityManager(em);
					EntityManagerUtil.getInstance().shutdownFactory();
				}
		}
		
 
	static void runM6Activity2(EntityManager em) {
		
		try {
			em.getTransaction().begin();
 
			Student newStudent = new Student();
			newStudent.setName("Dowa");
			newStudent.setAge(34);
			newStudent.setEmail("dowa34@gmail.com");
 
			em.persist(newStudent);
			em.getTransaction().commit();
		} finally {
			 if (em.isOpen()) {
		            em.close();
		        }
 
		}
 
	}
}
