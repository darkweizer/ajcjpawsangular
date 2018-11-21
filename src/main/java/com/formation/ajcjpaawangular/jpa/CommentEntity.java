package com.formation.ajcjpaawangular.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	private String libelle;
	private String body;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "comment_idUser")
	private UserEntity user;

	public CommentEntity() {

	}

	public CommentEntity(String libelle, String body) {
		super();
		this.libelle = libelle;
		this.body = body;
	}


	@Override
	public String toString() {
		return "Comment [idComment=" + id + ", libelle=" + libelle + ", body=" + body + "]";
	}

}
