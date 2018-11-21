package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String img;
    private Double price;
    private String dispo;
    private Integer stock;

    @OneToMany(mappedBy = "product")
    private List<CommentEntity> commentList;

    @OneToMany(mappedBy = "product")
    private List<OrderRowEntity> ordersRowList;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "products_familymealID")
    private FamilyMealEntity familyMealEntity;
}
