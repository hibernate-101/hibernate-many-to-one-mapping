package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Items;
import com.hibernate.model.ItemsAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;


public class HibernateAntnManyToOneMappingDelete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();

		ItemsAnnotation item = (ItemsAnnotation) session.get(ItemsAnnotation.class, 26L);

		session.delete(item);
		tx.commit();
		System.out.println("Many to one delete done...!");
		sessionFactory.close();
	}

}
