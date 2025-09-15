package com.order.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestHibernate {

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

		SessionFactory sessionFactory = new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		ProOrderVO proOrderVO = session.get(ProOrderVO.class, 1);
		System.out.println(proOrderVO);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
}
