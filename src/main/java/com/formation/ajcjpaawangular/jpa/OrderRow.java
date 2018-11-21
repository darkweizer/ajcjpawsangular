package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class OrderRow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private  Integer idOrderRow;

	private int quantie;
	private double total;

	public OrderRow() {

	}

	public OrderRow(int quantie, double total) {
		this.quantie = quantie;
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderRow [idOrderRow=" + idOrderRow + ", quantie=" + quantie + ", total=" + total + "]";
	}


}
