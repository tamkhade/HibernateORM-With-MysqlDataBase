package com.hibernate;  

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
		
		Employee e1=new Employee();  
		e1.setId(101);  
		e1.setFirstName("Gaurav");  
		e1.setLastName("Chawla");  

		session.save(e1);
		t.commit();
		System.out.println("successfully saved");  
		session.close();  
	}  
} 