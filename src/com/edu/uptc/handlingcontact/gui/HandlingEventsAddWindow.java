package com.edu.uptc.handlingcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;
import com.edu.uptc.handlingcontacts.model.Contact;

public class HandlingEventsAddWindow implements ActionListener {
	
	private AddContactWindow addContactWindow;
	
	public static final String GET_BACK = "GET_BACK";
	public static final String ADD_CONTACT = "ADD_CONTACT";
	
	private HandlingPersitenceContact handlingPersitenceContact;
	
	public HandlingEventsAddWindow(AddContactWindow addContactWindow) {
		this.addContactWindow = addContactWindow;
		this.handlingPersitenceContact = new HandlingPersitenceContact();
		this.handlingPersitenceContact.loadFile(ETypeFile.FILE_PLAIN);
	}
	
	private void flushData() {
		this.handlingPersitenceContact.dumpFile(ETypeFile.FILE_PLAIN);
		this.handlingPersitenceContact.dumpFile(ETypeFile.CSV);
		this.handlingPersitenceContact.dumpFile(ETypeFile.XML);
		this.handlingPersitenceContact.dumpFile(ETypeFile.JSON);
		this.handlingPersitenceContact.dumpFile(ETypeFile.SER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case GET_BACK:
				
				this.addContactWindow.getPanelMiddleAddContactWindow().getInputCode().setText("");
				this.addContactWindow.getPanelMiddleAddContactWindow().getInputName().setText("");
				this.addContactWindow.getPanelMiddleAddContactWindow().getInputPhoneNumber().setText("");
				this.addContactWindow.getPanelMiddleAddContactWindow().getInputEmail().setText("");
				this.addContactWindow.getPanelMiddleAddContactWindow().getInputAddress().setText("");
				this.addContactWindow.getPanelMiddleAddContactWindow().getInputIpAddress().setText("");
				
				/* Se oculta la vista de agregar contacto */
				this.addContactWindow.setVisible(false);
				break;
			case ADD_CONTACT:
				String code = this.addContactWindow.getPanelMiddleAddContactWindow().getInputCode().getText();
				String name = this.addContactWindow.getPanelMiddleAddContactWindow().getInputName().getText();
				String phoneNumber = this.addContactWindow.getPanelMiddleAddContactWindow().getInputPhoneNumber().getText();
				String email = this.addContactWindow.getPanelMiddleAddContactWindow().getInputEmail().getText();;
				String address = this.addContactWindow.getPanelMiddleAddContactWindow().getInputAddress().getText();
				String ipAddress = this.addContactWindow.getPanelMiddleAddContactWindow().getInputIpAddress().getText();
				
				Contact contact = new Contact(code, name, phoneNumber, email, address, ipAddress);
				
				this.handlingPersitenceContact.addContact(contact);
				
				/* Se realizan volcados para actualizar los archivos de bases de datos */
				this.flushData();
				
				JOptionPane.showMessageDialog(null, "Se creó el registro");
				
				break;
		}
		
	}

}
