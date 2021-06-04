package com.astrologer.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Customer_Details")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	private String name;
	private String contact;
	private Date joiningDate;
	private String gender;
	private String brithDate;
	private String bornLocation;
	private String following;
	private String coupon;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBrithDate() {
		return brithDate;
	}
	public void setBrithDate(String brithDate) {
		this.brithDate = brithDate;
	}
	public String getBornLocation() {
		return bornLocation;
	}
	public void setBornLocation(String bornLocation) {
		this.bornLocation = bornLocation;
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String contactUs) {
		this.coupon = contactUs;
	}
	
	
	
	
	

}
