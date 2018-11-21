package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    private String street;
    private String zipCode;
    private String city;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JoinColumn(name="address_userID")
    private UserEntity user;


    public AddressEntity() {

    }

    public AddressEntity(String street, String zipCode, String city) {
        this.street 	= street;
        this.zipCode 	= zipCode;
        this.city		= city;
    }
}
