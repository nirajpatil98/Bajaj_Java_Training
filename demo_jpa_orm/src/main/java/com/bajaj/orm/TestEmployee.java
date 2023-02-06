package com.bajaj.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Employee s1 = new Employee();
		s1.seteId(101);
		s1.setName("Gaurav");
		s1.setSalary(24);

		Employee s2 = new Employee();
		s2.seteId(102);
		s2.setName("Ronit");
		s2.setSalary(22);

		Employee s3 = new Employee();
		s3.seteId(103);
		s3.setName("Rahul");
		s3.setSalary(26);

		em.persist(s1);
		em.persist(s2);
		em.persist(s3);

		em.getTransaction().commit();
		emf.close();
		em.close();
	}
}