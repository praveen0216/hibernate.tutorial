package com.luv2code.hibernate.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.luv2code.hibernate.assignment.DateUtils;

@Entity
@Table(name = "Employee")
public class Employee {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "company")
	private String company;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public int getId() {
		return Id;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	

	public Employee(String firstName, String lastName, String company, Date dateofbirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.dateofbirth = dateofbirth;
	}

	public Employee() {

	}
	
	@Override
	public String toString() {
		return "Employee first name : "+this.firstName +" \nEmployee last name : "+this.lastName+"\nCompany name : "+this.company + "\nDateOfBirthe : "+ DateUtils.formatDate(this.dateofbirth);
	}

}
