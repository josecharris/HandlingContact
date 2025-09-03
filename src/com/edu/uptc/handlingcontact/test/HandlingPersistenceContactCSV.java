package com.edu.uptc.handlingcontact.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;
import com.edu.uptc.handlingcontacts.model.Contact;

import junit.framework.Assert;

class HandlingPersistenceContactCSV {

	private HandlingPersitenceContact handlingPersitenceContact
 		= new HandlingPersitenceContact();

	@Test
	void test() {
		this.scenarieOne();
		this.handlingPersitenceContact.dumpFile(ETypeFile.CSV);
	}
	
	@Test
	void test2() {
		this.scenarieTwo();
		Assert.assertEquals(4, 
				this.handlingPersitenceContact.getListContacts().size());
	}
	
	private void scenarieTwo() {
		/* Simulación de que la persona cerró el programa */
		this.handlingPersitenceContact.setListContacts(new ArrayList<>());
		
		Assert.assertTrue(this.handlingPersitenceContact.getListContacts()
				.isEmpty());
		
		/* Simulación de que la persona volvió a ejecutar el programa */
		this.handlingPersitenceContact.loadFile(ETypeFile.CSV);		
	}
	
	private void scenarieOne() {
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
		this.handlingPersitenceContact.addContact(contact);
		this.handlingPersitenceContact.addContact(contact2);
		this.handlingPersitenceContact.addContact(contact3);
		this.handlingPersitenceContact.addContact(contact4);
		this.handlingPersitenceContact.addContact(contact5);
	}

}
