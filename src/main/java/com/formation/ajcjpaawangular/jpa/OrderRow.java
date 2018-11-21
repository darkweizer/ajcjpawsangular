package com.formation.ajcjpaawangular.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderRow {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false)
	
		private  Integer idOrderRow;
		private int quantie;
		private double total;
		public OrderRow() {
			super();
			// TODO Auto-generated constructor stub
		}
		public OrderRow(int quantie, double total) {
			super();
			this.quantie = quantie;
			this.total = total;
		}
		public Integer getIdOrderRow() {
			return idOrderRow;
		}
		public void setIdOrderRow(Integer idOrderRow) {
			this.idOrderRow = idOrderRow;
		}
		public int getQuantie() {
			return quantie;
		}
		public void setQuantie(int quantie) {
			this.quantie = quantie;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		@Override
		public String toString() {
			return "OrderRow [idOrderRow=" + idOrderRow + ", quantie=" + quantie + ", total=" + total + "]";
		}
		
		
}
