package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.model.Items;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLManyToOneMappingSelectAll {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		// Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("Session opened");

		Query query = session.createQuery("From Items ");

		List items = query.list();
		Iterator itr = items.iterator();

		tx = session.beginTransaction();
		while (itr.hasNext()) {
			Items item = (Items) itr.next();
			System.out.println(item);
			Cart cart = item.getCart();
			System.out.println(cart);

		}

		tx.commit();
		System.out.println("many to one select is done..!!");
		sessionFactory.close();
	}

}
