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

    @ManyToMany(
            cascade= { CascadeType.PERSIST, CascadeType.MERGE}

    )
    @JoinTable(
            joinColumns=@JoinColumn(name="productsId"),
            inverseJoinColumns=@JoinColumn(name="typeMealId")
    )
    private List<TypeMealEntity> typeMealList;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "products_familymealID")
    private FamilyMealEntity familyMealEntity;

    public ProductsEntity() {
    }

    public ProductsEntity(String img, Double price, String dispo, Integer stock, List<CommentEntity> commentList, List<OrderRowEntity> ordersRowList, List<TypeMealEntity> typeMealList, FamilyMealEntity familyMealEntity) {
        this.img = img;
        this.price = price;
        this.dispo = dispo;
        this.stock = stock;
        this.commentList = commentList;
        this.ordersRowList = ordersRowList;
        this.typeMealList = typeMealList;
        this.familyMealEntity = familyMealEntity;
    }
}
