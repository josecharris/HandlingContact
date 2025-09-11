package com.edu.uptc.handlingcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;

public class HandlingEventsMainWindow implements ActionListener {
	
	public static final String LOAD_CONTACT_PLAIN = "LOAD_CONTACT_PLAIN";
	private HandlingPersitenceContact handlingPersitenceContact;
	private MainWindow mainwindow;
	
	public HandlingEventsMainWindow(MainWindow mainwindow) {
		this.handlingPersitenceContact = new HandlingPersitenceContact();
		this.mainwindow = mainwindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(LOAD_CONTACT_PLAIN)) {
			handlingPersitenceContact.setListContacts(new ArrayList<>());
			handlingPersitenceContact.loadFile(ETypeFile.FILE_PLAIN);
			this.clearTable();
			handlingPersitenceContact.getListContacts().forEach(contact -> {
				Object[] row = new Object[] {contact.getCode(), 
						contact.getName(), contact.getPhoneNumber(), contact.getEmail()};
				this.mainwindow.getPanelMiddleMainWindow().addRow(row);
			});
		}
	}
	
	private void clearTable(){
		for(int i = (this.mainwindow.getPanelMiddleMainWindow().getDtm()
				.getRowCount() - 1) ; i >= 0 ; i--){	
			this.mainwindow.getPanelMiddleMainWindow().getDtm().removeRow(i);
		}	
	}
	

}
