package com.stcokmodel;

import org.hibernate.Session;

import com.stock.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockCode("236325");
        stock.setStockName("tamkhade");
        
        session.save(stock);
        session.getTransaction().commit();
    }
}
