package com.contactapp.service;

import java.util.List;

import com.contactapp.DTO.Contact;


public interface ContactService {

	public boolean saveContact(Contact c);
	public Contact getContactById(Integer cid);
	public List<Contact> getAllContacts();
	public boolean deleteContactById(Integer cid);
}
