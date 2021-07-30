package com.example.login;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class jobs {
	@Id
	private String email;
	private String company;
	private String language;
	private String qualification;
	private String description;
	private double mobilenumber;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMobilenumber() {
		return  mobilenumber;
	}
	public void setMobilenumber(double mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

}
