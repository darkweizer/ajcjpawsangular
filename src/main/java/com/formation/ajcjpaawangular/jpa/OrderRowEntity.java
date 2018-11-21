package com.formation.ajcjpaawangular.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_rows")
public class OrderRowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private Integer quantie;
    private Double total;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "order_orderRow")
	private OrdersEntity order;
    
    public OrderRowEntity() {

    }

    public OrderRowEntity(Integer quantie, Double total) {
        this.quantie = quantie;
        this.total = total;
    }


    @Override
    public String toString() {
        return "OrderRow [idOrderRow=" + id + ", quantie=" + quantie + ", total=" + total + "]";
    }
}
