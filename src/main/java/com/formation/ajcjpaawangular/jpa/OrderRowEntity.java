package com.formation.ajcjpaawangular.jpa;

import javax.persistence.*;

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
    @JoinColumn(name = "products_orderrowID")
    private ProductsEntity product;

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
