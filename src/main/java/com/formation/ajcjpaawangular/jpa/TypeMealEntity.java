package com.formation.ajcjpaawangular.jpa;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "type_meal")
public class TypeMealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String libelle;

    @ManyToMany(mappedBy = "typeMealList")
    private List<ProductsEntity> productsList;

    public TypeMealEntity() {
    }

    public TypeMealEntity(String libelle, List<ProductsEntity> productsList) {
        this.libelle = libelle;
        this.productsList = productsList;
    }
}
