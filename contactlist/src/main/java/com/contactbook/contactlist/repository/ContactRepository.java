package com.contactbook.contactlist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactbook.contactlist.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

	 Page<Contact> findByNameContainsOrEmailContains(String name, String email, Pageable pageable);
	
}
