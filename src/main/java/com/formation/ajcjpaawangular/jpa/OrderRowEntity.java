package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.*;

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
