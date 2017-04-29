package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Items;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLManyToOneMappingDelete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();

		Items item = (Items) session.get(Items.class, 36L);

		session.delete(item);
		tx.commit();
		System.out.println("Many to one delete done...!");
		sessionFactory.close();

	}

}
