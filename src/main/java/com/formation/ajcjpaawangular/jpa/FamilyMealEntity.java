package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "family_meal")
public class FamilyMealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String libelle;
    private String description;

    @OneToMany(mappedBy = "familyMealEntity")
    private List<ProductsEntity> productsList;

    public FamilyMealEntity() {
    }

    public FamilyMealEntity(String libelle, String description, List<ProductsEntity> productsList) {
        this.libelle = libelle;
        this.description = description;
        this.productsList = productsList;
    }
}
