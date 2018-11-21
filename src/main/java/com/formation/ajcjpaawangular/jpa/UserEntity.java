package com.formation.ajcjpaawangular.jpa;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
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

    public UserEntity(String login, String email, String password, String firstname, String lastname, LocalDateTime birthday, String society, Boolean isAdmin, List<AddressEntity> addressList) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.society = society;
        this.isAdmin = isAdmin;
        this.addressList = addressList;
    }
}
