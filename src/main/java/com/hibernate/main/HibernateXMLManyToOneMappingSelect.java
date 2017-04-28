package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.model.Items;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLManyToOneMappingSelect {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		// Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		// start transaction
		tx = session.beginTransaction();

		Items item = (Items) session.get(Items.class, 54L);
		System.out.println(item);
		Cart cart = item.getCart();
		System.out.println(cart);

		tx.commit();
		System.out.println("many to one select is done..!!");
		sessionFactory.close();

	}

}
