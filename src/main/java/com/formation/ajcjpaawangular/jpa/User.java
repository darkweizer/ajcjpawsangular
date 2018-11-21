package com.formation.ajcjpaawangular.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
private Integer idUser;
private String lastName;
private String firstName;
private Date birthday;
private String password;
private String genre;
private String email;
private String Society;
private boolean isAdmin;

@OneToMany(mappedBy="user")
private List<Adress> adressList;

@OneToMany(mappedBy="user")
private List<Comment> commentList;

@OneToMany(mappedBy="user")
private List<OrderHeader> orderList;


public User() {
	// TODO Auto-generated constructor stub
}


public User(String lastName, String firstName, Date birthday, String password, String genre, String email,
		String society, boolean isAdmin) {
	super();
	this.lastName = lastName;
	this.firstName = firstName;
	this.birthday = birthday;
	this.password = password;
	this.genre = genre;
	this.email = email;
	Society = society;
	this.isAdmin = isAdmin;
}


public Integer getIdUser() {
	return idUser;
}


public void setIdUser(Integer idUser) {
	this.idUser = idUser;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public Date getBirthday() {
	return birthday;
}


public void setBirthday(Date birthday) {
	this.birthday = birthday;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getGenre() {
	return genre;
}


public void setGenre(String genre) {
	this.genre = genre;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getSociety() {
	return Society;
}


public void setSociety(String society) {
	Society = society;
}


public boolean isAdmin() {
	return isAdmin;
}


public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}



public List<Adress> getAdressList() {
	return adressList;
}


public void setAdressList(List<Adress> adressList) {
	this.adressList = adressList;
}



public List<Comment> getCommentList() {
	return commentList;
}


public void setCommentList(List<Comment> commentList) {
	this.commentList = commentList;
}


public List<OrderHeader> getOrderList() {
	return orderList;
}


public void setOrderList(List<OrderHeader> orderList) {
	this.orderList = orderList;
}


@Override
public String toString() {
	return "User [idUser=" + idUser + ", lastName=" + lastName + ", firstName=" + firstName + ", birthday=" + birthday
			+ ", password=" + password + ", genre=" + genre + ", email=" + email + ", Society=" + Society + ", isAdmin="
			+ isAdmin + "]";
}







	
}
