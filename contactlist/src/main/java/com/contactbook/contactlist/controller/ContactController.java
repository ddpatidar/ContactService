package com.contactbook.contactlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactbook.contactlist.entity.Contact;
import com.contactbook.contactlist.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	 @GetMapping("/contacts")
	 public List<Contact> getContacts(){
		 return contactService.getContacts();
	 }
	 
	 @GetMapping("/contact/id/{id}")
	 public Contact getContact(@PathVariable Integer id){
		 return contactService.getId(id);
	 }
	 
	 @PostMapping("/contact/newContact")
	 public void addContact(@RequestBody Contact payload){
		 contactService.newContact(payload);

	 }
	 
	 @DeleteMapping("/contact/remove/{id}")
	 public void removeContact(@PathVariable Integer id)
	 {
		 contactService.removeContact(id);
	 }
	 
    @PutMapping("/contact/modify")
    public String modifyContact(@RequestBody Contact data)
    {
    	return contactService.modifyContact(data);
    } 
    
    @GetMapping("/contact/search")
    public Page<Contact> searchContact(@RequestParam(required=false) String query, @RequestParam(required=false) int page)
    {
    	return contactService.searchContact(query, page);
    } 
}
