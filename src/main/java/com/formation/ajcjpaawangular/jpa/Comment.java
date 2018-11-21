package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer idComment;
	private String libelle;
	private String body;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "comment_idUser")
	private UserEntity user;

	public Comment() {

	}

	public Comment(String libelle, String body) {
		super();
		this.libelle = libelle;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", libelle=" + libelle + ", body=" + body + "]";
	}

}
