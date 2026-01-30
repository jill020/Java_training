package com.bpi.m6act3;

import jakarta.persistence.EntityManager;


public class App {
	

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity3(em);
				} finally {
					EntityManagerUtil.getInstance().closeEntityManager(em);
					EntityManagerUtil.getInstance().shutdownFactory();
				}
		}
	   
	   public static void runM6Activity3(EntityManager em) {
		    try {
		        em.getTransaction().begin();

		        Student student = new Student("Cath", 44, "Cath@gmail.com");
		        em.persist(student);
		        em.flush();
		        
		        Course math = new Course("Biology", "84", student);
		        Course science = new Course("Math", "79", student);

		        em.persist(math);
		        em.persist(science);
		        em.flush();
		        em.getTransaction().commit();
		        System.out.println("Student and courses persisted successfully!");
		    } catch (Exception e) {
		        if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (em.isOpen()) {
		            em.close();
		        }
		    }
		}
}
