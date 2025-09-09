package com.edu.uptc.handlingcontact.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersistenseUser;

class HandlingPersistenceUserTest {
	
	private HandlingPersistenseUser handlingPersistenseUser = new HandlingPersistenseUser();

	@Test
	void test() {
		this.handlingPersistenseUser.addUser("admin", "admin123");
		this.handlingPersistenseUser.addUser("jose", "1234");
		this.handlingPersistenseUser.dumpFile(ETypeFile.SER);
	}
	
	@Test
	void test2(){
		this.handlingPersistenseUser.setListUsers(new ArrayList<>());
		this.handlingPersistenseUser.loadFile(ETypeFile.SER);
		Assert.assertEquals(2, this.handlingPersistenseUser.getListUsers().size());
		Assert.assertTrue(handlingPersistenseUser.findUserByUsernamePassword("admin", "admin123"));
	}

}
