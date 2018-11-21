package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class OrderHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
private Integer idOrder;
private String type;
private Date date;
private Double price;
@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
@JoinColumn(name = "order_idUser")
private UserEntity user;

public OrderHeader() {
	// TODO Auto-generated constructor stub
}

public OrderHeader(Integer idOrder, String type, Date date, Double price) {
	super();
	this.idOrder = idOrder;
	this.type = type;
	this.date = date;
	this.price = price;
}

public OrderHeader(String type, Date date, Double price) {
	super();
	this.type = type;
	this.date = date;
	this.price = price;
}

@Override
public String toString() {
	return "Order [idOrder=" + idOrder + ", type=" + type + ", date=" + date + ", price=" + price + "]";
}


}
