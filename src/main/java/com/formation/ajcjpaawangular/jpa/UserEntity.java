package com.formation.ajcjpaawangular.jpa;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String login;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDateTime birthday;
    private String society;
    private Boolean isAdmin;

    @OneToMany(mappedBy="user")
    private List<AddressEntity> addressList;

    public UserEntity() {

    }

    public UserEntity(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.addressList = new ArrayList<AddressEntity>();
    }
}
