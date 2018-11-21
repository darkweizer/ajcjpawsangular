package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class OrdersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	private LocalDateTime date;
	private Double price;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "order_idUser")
	private UserEntity user;

	public OrdersEntity() {

	}

	public OrdersEntity(LocalDateTime date, Double price) {
		this.date = date;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + id + ", date=" + date + ", price=" + price + "]";
	}

}
