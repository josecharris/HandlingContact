package com.edu.uptc.handlingcontact.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;
import com.edu.uptc.handlingcontacts.model.Contact;

class HandlingPersistenceContactTestXML {
	
	private HandlingPersitenceContact handlingPersistenceContact =
			new HandlingPersitenceContact();
	@Test
	void test() {
		Contact contact = new Contact("001", "JOSE", "3227389121", 
				"jose.charris", "Calle 20", "127.0.0.1");
		Contact contact2 = new Contact("002", "ANGEL", "3227389***", 
				"angel.delarosa", "Calle XXXX", "127.0.0.1");
		Contact contact3 = new Contact("003", "ALEJANDRO", "3227389XXX", 
				"alejandro.castaneda", "Calle XXXX", "127.0.0.1"); 
		Contact contact4 = new Contact("004", "JORGE", "322738AAAA", 
				"jorge.abril", "Calle XXXX", "127.0.0.1");
		Contact contact5 = new Contact("001", "GERARDO", "3227389121", 
				"gerardo.araque", "Calle XXXX", "127.0.0.1");
		this.handlingPersistenceContact.addContact(contact);
		this.handlingPersistenceContact.addContact(contact2);
		this.handlingPersistenceContact.addContact(contact3);
		this.handlingPersistenceContact.addContact(contact4);
		this.handlingPersistenceContact.addContact(contact5);
		this.handlingPersistenceContact.dumpFile(ETypeFile.XML);
	}
	
	@Test
	void test2() {
		/* Simular el cierre cierre del programa */
		this.handlingPersistenceContact.setListContacts(new ArrayList<>());
		Assert.assertTrue(this.handlingPersistenceContact.getListContacts().isEmpty());
		this.handlingPersistenceContact.loadFile(ETypeFile.XML);
		Assert.assertEquals(4, this.handlingPersistenceContact.getListContacts().size());
		Assert.assertEquals("JOSE", 
				this.handlingPersistenceContact.getListContacts().get(0).getName());
	}

}
