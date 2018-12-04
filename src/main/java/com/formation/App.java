package com.formation;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.ajcjpaawangular.controller.HomeController;
import com.formation.ajcjpaawangular.jpa.NewsEntity;
import com.formation.ajcjpaawangular.jpa.OrdersEntity;
import com.formation.ajcjpaawangular.jpa.ProductsEntity;
import com.formation.ajcjpaawangular.jpa.TypeMealEntity;
import com.formation.ajcjpaawangular.utils.HibernateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.ajcjpaawangular.jpa.AddressEntity;
import com.formation.ajcjpaawangular.jpa.CommentEntity;
import com.formation.ajcjpaawangular.jpa.FamilyMealEntity;
import com.formation.ajcjpaawangular.jpa.NewsEntity;
import com.formation.ajcjpaawangular.jpa.OrderRowEntity;
import com.formation.ajcjpaawangular.jpa.OrdersEntity;
import com.formation.ajcjpaawangular.jpa.UserEntity;
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
       HomeController.getMaxVendu(s);
    	// Save data
    	
    	tx.commit();

    }

    private static void testCreate() {
    	NewsEntity myNews = new NewsEntity("title", "body"); 

    	List<OrdersEntity > listOrder= new ArrayList<OrdersEntity >();
    	List<OrderRowEntity > listOrderRow= new ArrayList<OrderRowEntity >();
    	ProductsEntity product= new  ProductsEntity( "csc","img", 10.2, "dispo", 5, null, listOrderRow, null,null);
    	List<AddressEntity > adressList= new ArrayList<AddressEntity >();
        
    	UserEntity user = new UserEntity("login", "email", "password", "firstName", "lastName", LocalDateTime.now(), "genre", "society", false, adressList);
         
    	
        OrdersEntity order = new OrdersEntity (LocalDateTime.now(), 20.5);
    	OrdersEntity order2 = new OrdersEntity (LocalDateTime.now(), 10.5);
    	OrderRowEntity  orderRow = new OrderRowEntity (2, 5.55);
    	orderRow.setProduct(product);
    	orderRow.setOrder(order2);
    	listOrderRow.add(orderRow);
       	AddressEntity  adress = new AddressEntity ("libelle Adress", "street", "2500"); 
    	AddressEntity  adress2 = new AddressEntity ("libelle Adress2", "street2", "2600"); 
    	
    	
    	adressList.add(adress);
    	adressList.add(adress2);
    	
    	adress.setUser(user);
    	adress2.setUser(user);
    	user.setAddressList(adressList);
    	
    	

    	listOrder.add(order);
    	listOrder.add(order2);
    	
    	order.setUser(user);
    	order2.setUser(user);
    	user.setOrderList(listOrder);
    	

    	s.persist(orderRow);
    	s.persist(order);
    	s.persist(myNews);

    	s.persist(adress);
    	s.persist(adress2);
    	s.persist(user);
    	s.persist(orderRow);
    	s.persist(order);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    	// Persistante objects created
    	s.persist(myNews);
    	

    }

}
