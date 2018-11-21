package com.formation;

import com.formation.ajcjpaawangular.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    /*
     * Declare variables
     */
    private static Session s = null;
    private static Transaction tx = null;


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        s = HibernateUtils.getSession();
        tx = s.beginTransaction();
        testCreate();
    }

    private static void testCreate() {

        // Persistante objects created

    }

}
