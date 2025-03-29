package com.soft.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_model")
public class UserModel {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
private  int id;
private String name;
private String email;
private String address;
private String pass;
private long phoneno;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public long getPhoneno() {
	return phoneno;
}
public void setPhoneno(long phoneno) {
	this.phoneno = phoneno;
	
}
@Override
public String toString() {
	return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", pass=" + pass
			+ ", phoneno=" + phoneno + "]";
}

}
