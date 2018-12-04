package com.formation.ajcjpaawangular.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.formation.ajcjpaawangular.jpa.NewsEntity;
import com.formation.ajcjpaawangular.jpa.ProductsEntity;

	public class HomeController {

		  public static void printNews(Session s) {
		    	
		    	System.out.println("[NewsEntity]");
		    	
		    	// Create Query
		    	Query _query 							= s.createQuery("from NewsEntity");
		    	ArrayList<NewsEntity> _newsEntity 	= (ArrayList<NewsEntity>)_query.list(); 
		    	
		    	// Show data
		    	for (NewsEntity newsEntity : _newsEntity) {
		    		System.out.println (
			    				"[id]= " + newsEntity.getId() + "\t" + 
			    				"[title] = " + newsEntity.getTitle()+ "\t" +
			    				"[img] = " + newsEntity.getImg()+ "\t" +
			    				"[body]	= " + newsEntity.getBody()
		        			);
		    		
				}
		    	
		    }
		  
			public static void getMaxVendu(Session s) {
			       
			       // Retrieve data in database
			       Query _q = s.createNativeQuery("SELECT foodtruck.products.*, SUM(foodtruck.order_rows.quantie) quantite\r\n" + 
			       		"FROM foodtruck.products,foodtruck.orders,foodtruck.order_rows \r\n" + 
			       		"where foodtruck.products.id=foodtruck.order_rows.products_orderrowID\r\n" + 
			       		"and foodtruck.order_rows.order_orderRow=foodtruck.orders.id\r\n" + 
			       		"ORDER BY quantite asc\r\n" + 
			       		"LIMIT 1");
			      
			
			       List<Object[]> products = _q.getResultList();
			       for (Object[] a : products) {
			    	  
			    	   ProductsEntity p= new ProductsEntity((Integer)a[0],(String)a[3],(String)a[2],(Double)a[4],(String)a[1],(Integer)a[5]);
			    			   
			    	   System.out.println("best produect is "+p.toString());
			       }
			       
			       
				
			}

		  

	}

