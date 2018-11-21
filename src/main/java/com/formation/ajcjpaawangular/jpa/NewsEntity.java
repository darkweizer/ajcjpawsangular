package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "news")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String title;
    private String body;

    public NewsEntity() {

    }

    public NewsEntity(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
