package com.formation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.ajcjpaawangular.controller.HomeController;
import com.formation.ajcjpaawangular.jpa.NewsEntity;
import com.formation.ajcjpaawangular.utils.HibernateUtils;

public class App {

    /*
     * Declare variables
     */
    private static Session s = null;
    private static Transaction tx = null;


    public static void main( String[] args )
    {
        s = HibernateUtils.getSession();
        tx = s.beginTransaction();
        testCreate();
        HomeController.printNews(s);
    	// Save data
    	
    	tx.commit();

    }

    private static void testCreate() {
    	NewsEntity myNews = new NewsEntity("title", "body"); 
        // Persistante objects created
    	s.persist(myNews);

    }

}
