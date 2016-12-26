package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity 
public class Customer implements Serializable {

	public static final long serialVersionUID = -723583058586873479L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int custID;
	@Column
	public String name;
	@Column
	public String address;
	@Column
	public String password;
	@Column
	public String phno;
	@Column
	public String email;
	public Customer()
	{}
	public Customer(int custID,String name,String password, String phno,String email){
		super();
		this.custID=custID;
		this.name=name;
		this.password=password;
		this.phno=phno;
		this.email=email;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
