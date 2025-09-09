package com.edu.uptc.handlingcontact.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.interfaces.IActionsFile;
import com.edu.uptc.handlingcontacts.model.User;

public class HandlingPersistenseUser extends FilePlain implements IActionsFile {

	private List<User> listUsers;
	
	public HandlingPersistenseUser() {
		this.listUsers = new ArrayList<>();
	}
	
	public Boolean addUser(String username, String password) {
		if(Boolean.FALSE.equals(this.findUserByUsernamePassword(username, password))) {
			this.listUsers.add(new User(username, password));
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean findUserByUsernamePassword(String nameUser, String password) {
		return listUsers.stream()
	            .anyMatch(u -> u.getUsername().equals(nameUser) 
	            		&& u.getPassword().equals(password));
	}
	
	@Override
	public void loadFile(ETypeFile eTypeFile) {
		if(ETypeFile.SER.equals(eTypeFile)) {
			this.loadFileSerializate();
		}
		
	}

	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.SER.equals(eTypeFile)) {
			this.dumpFileSerializate();
		}
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(
				this.config.getPathFiles()
				.concat(this.config.getNameFileUserSer()));
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            out.writeObject(this.listUsers);
	    } catch (IOException i) {
	    	i.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.config.getPathFiles()
				.concat(this.config.getNameFileUserSer()));
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
			this.listUsers = (List<User>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
	    }
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	
	
}
