package com.hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CartModel
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int cartId;
	
	private String cartName;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=ItemModel.class,mappedBy="cartModel")
	private List<ItemModel> itemModelList;
	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public List<ItemModel> getItemModelList() {
		return itemModelList;
	}

	public void setItemModelList(List<ItemModel> itemModelList) {
		this.itemModelList = itemModelList;
	}
	
}
