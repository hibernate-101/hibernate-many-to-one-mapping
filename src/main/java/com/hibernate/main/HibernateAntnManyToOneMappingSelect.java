package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.CartAnnotation;
import com.hibernate.model.ItemsAnnotation;
import com.hibernate.util.HibernateAnnotationUtil;

public class HibernateAntnManyToOneMappingSelect {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		// Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		// start transaction
		tx = session.beginTransaction();

		ItemsAnnotation item = (ItemsAnnotation) session.get(
				ItemsAnnotation.class, 55L);
		System.out.println(item);
		CartAnnotation cart = item.getCart();
		System.out.println(cart);
		ItemsAnnotation item1 = (ItemsAnnotation) session.get(
				ItemsAnnotation.class, 56L);
		System.out.println(item1);
		CartAnnotation cart1 = item1.getCart();
		System.out.println(cart1);


		tx.commit();
		System.out.println("many to one select is done..!!");
		sessionFactory.close();
	}

}
