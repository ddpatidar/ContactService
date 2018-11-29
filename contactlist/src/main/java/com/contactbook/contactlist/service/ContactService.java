package com.contactbook.contactlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.contactbook.contactlist.entity.Contact;
import com.contactbook.contactlist.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}

	public Contact getId(Integer id){
		return contactRepository.findById(id).get();
	}
	
	public void newContact(Contact requestBody){
		Contact addContact = new Contact();
		addContact.setId(requestBody.getId());
		addContact.setName(requestBody.getName());
		contactRepository.save(addContact);
	}

	public void removeContact(Integer id) {
         contactRepository.deleteById(id);
	}
	
	public String modifyContact(Contact contact)
	{
		Contact savedContact = contactRepository.save(contact);
		return savedContact.getName();
	}
	
	public Page<Contact> searchContact(String query, int page){
		return contactRepository.findByNameContainsOrEmailContains(query, query, PageRequest.of(page-1, 10));
	}
}
