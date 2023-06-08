package com.contactapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactapp.DTO.Contact;
import com.contactapp.entity.ContactEntity;
import com.contactapp.repository.ContactRepo;
import com.contactapp.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;

	@Override
	public boolean saveContact(Contact c) {
		if(c.getContactNumber().isEmpty()) {
			return false;
		}else {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId() != null;
		}
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> optional = contactRepo.findById(cid);
		if(optional.isPresent()) {
			ContactEntity contactEntity = optional.get();
			Contact con=new Contact();
			BeanUtils.copyProperties(contactEntity, con);
			return con;
		}
		return null;
		
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList=new ArrayList<Contact>();
		List<ContactEntity> entities = contactRepo.findAll();
		entities.forEach(entity->{
			Contact c= new Contact();
			BeanUtils.copyProperties(entity, c);
			contactList.add(c);
			
		});
		
		return contactList ;
	}


	@Override
	public boolean deleteContactById(Integer id) {
		contactRepo.deleteById(id);
		return true;
	}

}
