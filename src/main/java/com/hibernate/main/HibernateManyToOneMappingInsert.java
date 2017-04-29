package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Cart;
import com.hibernate.model.Items;
import com.hibernate.util.HibernateUtil;

public class HibernateManyToOneMappingInsert {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.setName("My Cart");

		Items item1 = new Items("i101",2 * 100,2,cart);
		

		Items item2 = new Items("i102",3*100,3,cart);
		
		//cart.setTotal(item1.getItemTotal());

		cart.setTotal(item1.getItemTotal() + item2.getItemTotal());
		item1.setCart(cart);
		item2.setCart(cart);

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			// start transaction
			tx = session.beginTransaction();

			// Save the Model objects

			session.save(item1);
			session.save(item2);

			// Commit transaction
			tx.commit();
			System.out.println("Data inserted successfully");

		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}

	}
}
