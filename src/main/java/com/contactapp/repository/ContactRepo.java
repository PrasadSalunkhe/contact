package com.contactapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contactapp.entity.ContactEntity;


public interface ContactRepo extends JpaRepository<ContactEntity, Serializable>{

}
