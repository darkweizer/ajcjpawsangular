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
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String genre;
    private String society;
    private Boolean isAdmin;

    @OneToMany(mappedBy="user")
    private List<AddressEntity> addressList;

    @OneToMany(mappedBy="user")
    private List<Comment> commentList;

    @OneToMany(mappedBy="user")
    private List<OrderHeader> orderList;

    public UserEntity() {

    }

    public UserEntity(String login, String email, String password, String firstName, String lastName, LocalDateTime birthday, String genre, String society, Boolean isAdmin, List<AddressEntity> addressList) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.genre = genre;
        this.society = society;
        this.isAdmin = isAdmin;
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "User [idUser=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", birthday=" + birthday
                + ", password=" + password + ", genre=" + genre + ", email=" + email + ", Society=" + society + ", isAdmin="
                + isAdmin + "]";
    }
}
