package com.formation.ajcjpaawangular.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdersEntity {
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

	public OrdersEntity() {
		// TODO Auto-generated constructor stub
	}

	public OrdersEntity(Integer idOrder, String type, Date date, Double price) {
		super();
		this.idOrder = idOrder;
		this.type = type;
		this.date = date;
		this.price = price;
	}

	public OrdersEntity(String type, Date date, Double price) {
		super();
		this.type = type;
		this.date = date;
		this.price = price;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", type=" + type + ", date=" + date + ", price=" + price + "]";
	}

}
