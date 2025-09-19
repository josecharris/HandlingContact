package com.edu.uptc.handlingcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;
import com.edu.uptc.handlingcontacts.model.Contact;

public class HandlingEventsAddWindow implements ActionListener {
	
	private MainWindow mainWindow;
	
	public static final String GET_BACK = "GET_BACK";
	public static final String ADD_CONTACT = "ADD_CONTACT";	
	
	public HandlingEventsAddWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	private void flushData() {
		this.mainWindow.getHandlingPersitenceContact().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersitenceContact().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersitenceContact().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersitenceContact().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersitenceContact().dumpFile(ETypeFile.SER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case GET_BACK:
				
				this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputCode().setText("");
				this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputName().setText("");
				this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputPhoneNumber().setText("");
				this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputEmail().setText("");
				this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputAddress().setText("");
				this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputIpAddress().setText("");
				
				/* Se oculta la vista de agregar contacto */
				this.mainWindow.getAddContactWindow().setVisible(false);
				break;
			case ADD_CONTACT:
				String code = this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputCode().getText();
				String name = this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputName().getText();
				String phoneNumber = this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputPhoneNumber().getText();
				String email = this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputEmail().getText();;
				String address = this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputAddress().getText();
				String ipAddress = this.mainWindow.getAddContactWindow().getPanelMiddleAddContactWindow().getInputIpAddress().getText();
				
				Contact contact = new Contact(code, name, phoneNumber, email, address, ipAddress);
				
				if(this.mainWindow.getHandlingPersitenceContact().addContact(contact)) {
					/* Se realizan volcados para actualizar los archivos de bases de datos */
					this.flushData();
					
					/* Se oculta el formulario */
					this.mainWindow.getAddContactWindow().setVisible(false);
					
					/* Que se actualice la tabla con el nuevo registro */
					/* 1. Se limpie la tabla*/
					/* 2. Se vuelva cargar con la info actualizada */
					
					JOptionPane.showMessageDialog(null, "Se creó el registro");
					this.loadInfoTable(ETypeFile.FILE_PLAIN);
				}
				
				break;
		}
		
	}
	
	private void loadInfoTable(ETypeFile eTypeFile) {
		this.mainWindow.getHandlingPersitenceContact().setListContacts(new ArrayList<>());
		this.mainWindow.getHandlingPersitenceContact().loadFile(eTypeFile);
		this.clearTable();
		this.mainWindow.getHandlingPersitenceContact().getListContacts().forEach(contact -> {
			Object[] row = new Object[] {contact.getCode(), 
					contact.getName(), contact.getPhoneNumber(), contact.getEmail()};
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
	}
	
	private void clearTable(){
		for(int i = (this.mainWindow.getPanelMiddleMainWindow().getDtm()
				.getRowCount() - 1) ; i >= 0 ; i--){	
			this.mainWindow.getPanelMiddleMainWindow().getDtm().removeRow(i);
		}	
	}

}
