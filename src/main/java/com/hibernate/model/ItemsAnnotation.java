package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class ItemsAnnotation {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "item_id")
	private String itemId;
	@Column(name = "item_total")
	private double total;

	@Column(name = "quantity")
	private int itemQuantity;
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private CartAnnotation cart;

	public ItemsAnnotation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsAnnotation(String itemId, double total, int itemQuantity,
			CartAnnotation cart) {
		super();
		this.itemId = itemId;
		this.total = total;
		this.itemQuantity = itemQuantity;
		this.cart = cart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public CartAnnotation getCart() {
		return cart;
	}

	public void setCart(CartAnnotation cart) {
		this.cart = cart;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemsAnnotation [id=" + id + ", itemId=" + itemId + ", total="
				+ total + ", itemQuantity=" + itemQuantity + "]";
	}
	
	

}
