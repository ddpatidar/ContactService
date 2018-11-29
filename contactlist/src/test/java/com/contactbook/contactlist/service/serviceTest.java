package com.contactbook.contactlist.service;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.contactbook.contactlist.entity.Contact;
import com.contactbook.contactlist.repository.ContactRepository;

public class serviceTest {
	
	@Mock
	ContactRepository contactRepository;
	
	@InjectMocks
	ContactService contactService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testContactListShouldReturnDataAsExpected()
	{
		//DATA
		Contact contact1 = new Contact();
		contact1.setId(1);
		contact1.setName("ram");
		contact1.setEmail("ram@gmail.com");
		
		Contact contact2 = new Contact();
		contact2.setId(2);
		contact2.setName("shyam");
		contact2.setEmail("shyam@gmail.com");
		
		Contact contact3 = new Contact();
		contact3.setId(3);
		contact3.setName("suyash");
		contact3.setEmail("suyash@gmail.com");
		
		Contact contact4 = new Contact();
		contact4.setId(4);
		contact4.setName("");
		contact4.setEmail("suyash@gmail.com");
		
		
		List<Contact> expectedContacts = new ArrayList<>();
		expectedContacts.add(contact1);
		expectedContacts.add(contact2);
		expectedContacts.add(contact3);
		expectedContacts.add(contact4);
		
		List<Contact> dbContacts = new ArrayList<>();
		dbContacts.add(contact1);
		dbContacts.add(contact2);
		dbContacts.add(contact3);
		
		
		//Assumption
		when(contactRepository.findAll()).thenReturn(dbContacts);
		
		List<Contact> actualContacts = contactService.getContacts();
		
		//Assertion
		Assert.assertEquals(expectedContacts.get(0), actualContacts.get(0));
		Assert.assertTrue(!actualContacts.isEmpty());
	}

	@Test
	public void testGetContactWhereNameIsNotNull(){
		
		//Data
		Contact expectedContact = new Contact();
		expectedContact.setId(1);
		expectedContact.setName("ram");
		expectedContact.setEmail("ram@gmail.com");
		
		//Mocking repository
		when(contactRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(expectedContact));
		
		//Service Calling
		Contact actualContact = contactService.getId(1);
		
		//Assert
		Assert.assertEquals(expectedContact, actualContact);
		Assert.assertTrue(!actualContact.getName().isEmpty());
		
	}
	
	@Test
	public void testGetContactWhereContactIsDeleted(){
		
		//Data
		
		Contact expectedContact = new Contact();
		expectedContact.setId(1);
		expectedContact.setName("Ram");
		expectedContact.setEmail("Ram@gmail.com");
		Contact expectedContact1 = new Contact();
		expectedContact1.setId(2);
		expectedContact1.setName("shyam");
		expectedContact1.setEmail("shyam@gmail.com");
	
		contactService.removeContact(2);
	//	Assert.assertNull(contactService.getId(2));
		
		//test for exception handling when you try to remove null
		//contactService.removeContact(null);
		
	}
	
	
}
