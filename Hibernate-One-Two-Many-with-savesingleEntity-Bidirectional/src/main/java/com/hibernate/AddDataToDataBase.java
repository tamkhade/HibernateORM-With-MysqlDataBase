package com.hibernate;  

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AddDataToDataBase { 

	public static SessionFactory getSessionFactory() 
	{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;		
	}

	public static void main(String[] args) 
	{  

		Session session = getSessionFactory().openSession();    
		Transaction t = session.beginTransaction(); 
		
		CartModel cartModel = new CartModel();
		cartModel.setCartName("Facebook");
		List<ItemModel> itemlist = new ArrayList<ItemModel>();
		ItemModel itemModel = new ItemModel();
		itemModel.setItemName("bag");
		itemlist.add(itemModel);
		itemModel.setCartModel(cartModel);
		cartModel.setItemModelList(itemlist);
	
		session.save(cartModel);
		t.commit();
		System.out.println("successfully saved");  
		session.close();  
	}  
} 