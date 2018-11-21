package com.formation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.ajcjpaawangular.jpa.Adress;
import com.formation.ajcjpaawangular.jpa.Comment;
import com.formation.ajcjpaawangular.jpa.OrderHeader;
import com.formation.ajcjpaawangular.jpa.OrderRow;
import com.formation.ajcjpaawangular.jpa.User;
import com.formation.ajcjpaawangular.utils.HibernateUtils;

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
	 
       	// add user
    	User user = new User( "lastName", "firstName", new Date(), "password", "genre", "email","society", false);
    	OrderHeader order = new OrderHeader ("type",new Date(), 20.5);
    	OrderHeader order2 = new OrderHeader ("type2",new Date(), 10.5);
    	Comment comment = new Comment ("libelle", "body");
    	Comment comment2 = new Comment ("libelle2", "body2");
    	OrderRow orderRow = new OrderRow(2, 5.55);
    	Adress adress = new Adress("libelle Adress", "street", 2500); 
    	Adress adress2 = new Adress("libelle Adress2", "street2", 2600); 
    	
    	List<Adress> adressList= new ArrayList<Adress>();
    	adressList.add(adress);
    	adressList.add(adress2);
    	
    	adress.setUser(user);
    	adress2.setUser(user);
    	user.setAdressList(adressList);
    	
    	List<Comment> commentList =    new ArrayList<Comment>();
    	commentList.add(comment);
    	commentList.add(comment2);
    	
    	comment.setUser(user);
    	comment2.setUser(user);
    	user.setCommentList(commentList);

    	List<OrderHeader> listOrder= new ArrayList<OrderHeader>();
    	listOrder.add(order);
    	listOrder.add(order2);
    	
    	order.setUser(user);
    	order2.setUser(user);
    	user.setOrderList(listOrder);
    	
    	s.persist(adress);
    	s.persist(adress2);
    	s.persist(comment);
    	s.persist(comment2);
    	s.persist(order);
    	s.persist(order2);
    	s.persist(user);
    	s.persist(orderRow);
    	
    	
    	// Save data
    	
    	tx.commit();

    }
   
}
