package com.formation.ajcjpaawangular.controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.formation.ajcjpaawangular.jpa.NewsEntity;

	public class HomeController {

		  public static void printNews(Session s) {
		    	
		    	System.out.println("[NewsEntity]");
		    	
		    	// Create Query
		    	Query _query 							= s.createQuery("from NewsEntity");
		    	ArrayList<NewsEntity> _newsEntity 	= (ArrayList<NewsEntity>)_query.list(); 
		    	
		    	// Show data
		    	for (NewsEntity newsEntity : _newsEntity) {
		    		System.out.println (
			    				"[id] 							= " + newsEntity.getId() + "\t" + 
			    				"[title] 							= " + newsEntity.getTitle()+ "\t" +
			    				"[img] 							= " + newsEntity.getImg()+ "\t" +
			    				"[body]							= " + newsEntity.getBody()
		        			);
		    		
				}
		    	
		    }
		  

	}

