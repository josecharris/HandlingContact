package com.edu.uptc.handlingcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;

public class HandlingEventsMainWindow implements ActionListener {
	
	public static final String LOAD_CONTACT_PLAIN = "LOAD_CONTACT_PLAIN";
	public static final String LOAD_CONTACT_XML = "LOAD_CONTACT_XML";
	
	public static final String ADD_CONTACT = "ADD_CONTACT";
	
	public static final String SEE_MORE_CONTACT = "SEE_MORE_CONTACT";
	
	private HandlingPersitenceContact handlingPersitenceContact;
	private MainWindow mainwindow;
	
	public HandlingEventsMainWindow(MainWindow mainwindow) {
		this.handlingPersitenceContact = new HandlingPersitenceContact();
		this.mainwindow = mainwindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case LOAD_CONTACT_PLAIN:
				this.loadInfoTable(ETypeFile.FILE_PLAIN);
				break;
			case LOAD_CONTACT_XML:
				this.loadInfoTable(ETypeFile.XML);
				break;
			case SEE_MORE_CONTACT:
				this.mainwindow.getAddContactWindow().setVisible(true);
				break;
			case ADD_CONTACT:
				this.mainwindow.getAddContactWindow().setVisible(true);
				break;
		}
	}
	
	private void loadInfoTable(ETypeFile eTypeFile) {
		handlingPersitenceContact.setListContacts(new ArrayList<>());
		handlingPersitenceContact.loadFile(eTypeFile);
		this.clearTable();
		handlingPersitenceContact.getListContacts().forEach(contact -> {
			Object[] row = new Object[] {contact.getCode(), 
					contact.getName(), contact.getPhoneNumber(), contact.getEmail()};
			this.mainwindow.getPanelMiddleMainWindow().addRow(row);
		});
	}
	
	private void clearTable(){
		for(int i = (this.mainwindow.getPanelMiddleMainWindow().getDtm()
				.getRowCount() - 1) ; i >= 0 ; i--){	
			this.mainwindow.getPanelMiddleMainWindow().getDtm().removeRow(i);
		}	
	}
	

}
