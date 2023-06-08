package com.contactapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Contact_Details_Table")
public class ContactEntity {

	@Id
	@GeneratedValue
	@Column(name="contactId")
	private Integer contactId;
	
	@Column(name="contactName")
	private String contactName;
	
	@Column(name="contactEmail")
	private String contactEmail;
	
	@Column(name="contactNumber")
	private String contactNumber;
}
