package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemModel 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int itemId;
	private String itemName;
	
	@ManyToOne
	@JoinColumn(name="cartId", nullable=false)
	private CartModel cartModel;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public CartModel getCartModel() {
		return cartModel;
	}
	public void setCartModel(CartModel cartModel) {
		this.cartModel = cartModel;
	}
	
}
