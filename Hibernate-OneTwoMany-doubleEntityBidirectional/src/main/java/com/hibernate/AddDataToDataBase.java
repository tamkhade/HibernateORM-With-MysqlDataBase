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
		cartModel.setCartId(1233);
		cartModel.setCartName("amazon");
		List<ItemModel> itemlist = new ArrayList<ItemModel>();
		ItemModel itemModel = new ItemModel();
		itemModel.setItemId(12455);
		itemModel.setItemName("laptop");
		itemModel.setCartModel(cartModel);
		itemlist.add(itemModel);
		cartModel.setItemModelList(itemlist);
	
		session.save(cartModel);
		session.save(itemModel);
		t.commit();
		System.out.println("successfully saved");  
		session.close();  
	}  
} 