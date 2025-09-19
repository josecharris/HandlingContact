package com.edu.uptc.handlingcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersitenceContact;
import com.edu.uptc.handlingcontacts.model.Contact;

public class HandlingEventsMainWindow implements ActionListener {
	
	public static final String LOAD_CONTACT_PLAIN = "LOAD_CONTACT_PLAIN";
	public static final String LOAD_CONTACT_CSV = "LOAD_CONTACT_CSV";
	public static final String LOAD_CONTACT_XML = "LOAD_CONTACT_XML";
	public static final String LOAD_CONTACT_JSON = "LOAD_CONTACT_JSON";
	public static final String LOAD_CONTACT_SERIALIZATE = "LOAD_CONTACT_SERIALIZATE";
	public static final String ADD_CONTACT = "ADD_CONTACT";
	
	public static final String SEE_MORE_CONTACT = "SEE_MORE_CONTACT";
	public static final String DELETE_CONTACT = "DELETE_CONTACT";
	public static final String UPDATE_CONTACT = "UPDATE_CONTACT";
	
	public static final String SHOW_WINDOW_FIND_CONTACT = "SHOW_WINDOW_FIND_CONTACT";
	public static final String HIDE_WINDOW_FIND_CONTACT = "HIDE_WINDOW_FIND_CONTACT";
	public static final String FIND_CONTACT_BY_ATTRIBUTE = "FIND_CONTACT_BY_ATTRIBUTE";
	
	private MainWindow mainwindow;
	
	public HandlingEventsMainWindow(MainWindow mainwindow) {
		this.mainwindow = mainwindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case LOAD_CONTACT_PLAIN:
				this.loadInfoTable(ETypeFile.FILE_PLAIN);
				break;
			case LOAD_CONTACT_CSV:
				this.loadInfoTable(ETypeFile.CSV);
				break;
			case LOAD_CONTACT_XML:
				this.loadInfoTable(ETypeFile.XML);
				break;
			case LOAD_CONTACT_JSON:
				this.loadInfoTable(ETypeFile.JSON);
				break;
			case LOAD_CONTACT_SERIALIZATE:
				this.loadInfoTable(ETypeFile.SER);
				break;
			case SEE_MORE_CONTACT:
				String code = HandlingPersitenceContact.CODE_CONTACT_SELECTED;
				Contact contactSeeMore = this.mainwindow.getHandlingPersitenceContact().findContactByIndex(0, code);
				StringBuilder content = new StringBuilder();
				content.append("Código: " + contactSeeMore.getCode() + "\n");
				content.append("Nombre: " + contactSeeMore.getName() + "\n");
				content.append("Número de teléfono: " + contactSeeMore.getPhoneNumber() + "\n");
				content.append("Email: " + contactSeeMore.getEmail() + "\n");
				content.append("Dirección: " + contactSeeMore.getAddress() + "\n");
				content.append("Dirección IP: " + contactSeeMore.getIpAddress() + "\n");
				JOptionPane.showMessageDialog(null, content.toString(), "Información contacto", 
						JOptionPane.DEFAULT_OPTION);
				break;
			case ADD_CONTACT:
				this.mainwindow.getAddContactWindow().setVisible(true);
				break;
			case DELETE_CONTACT:
				int option = JOptionPane.showConfirmDialog(null, 
						"¿Estás seguro de que deseas eliminar el registro?",
						"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.YES_OPTION) {
					this.mainwindow.getHandlingPersitenceContact().deleteContact(
							HandlingPersitenceContact.CODE_CONTACT_SELECTED);
					this.flushData();
					this.loadInfoTable(ETypeFile.CSV);
				}
				break;
			case SHOW_WINDOW_FIND_CONTACT:
				this.mainwindow.getFindContactWindow().setVisible(true);
				break;
			case HIDE_WINDOW_FIND_CONTACT:
				this.mainwindow.getFindContactWindow().setVisible(false);
				break;
			case FIND_CONTACT_BY_ATTRIBUTE:
				int index = mainwindow.getFindContactWindow().getComboAttribute().getSelectedIndex();
				String value = mainwindow.getFindContactWindow().getTxtValue().getText();
				Contact contact = mainwindow.getHandlingPersitenceContact().findContactByIndex(index, value);
				this.clearTable();
				Object[] row = new Object[] {contact.getCode(), 
						contact.getName(), contact.getPhoneNumber(), contact.getEmail()};
				this.mainwindow.getPanelMiddleMainWindow().addRow(row);
				break;
			case UPDATE_CONTACT:
				System.out.println("Actualizar");
				int fila = this.mainwindow.getPanelMiddleMainWindow().getTable().getSelectedRow();
				String codeSelected = this.mainwindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 0).toString();
				String name = this.mainwindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 1).toString();
				String phoneNumber = this.mainwindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 2).toString();
				String email = this.mainwindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 3).toString();
				Contact contactUpdate = new Contact(codeSelected, name, phoneNumber, email);
				this.mainwindow.getHandlingPersitenceContact().updateContact(contactUpdate);
				this.flushData();
				break;
		}
	}
	
	private void flushData() {
		this.mainwindow.getHandlingPersitenceContact().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainwindow.getHandlingPersitenceContact().dumpFile(ETypeFile.CSV);
		this.mainwindow.getHandlingPersitenceContact().dumpFile(ETypeFile.XML);
		this.mainwindow.getHandlingPersitenceContact().dumpFile(ETypeFile.JSON);
		this.mainwindow.getHandlingPersitenceContact().dumpFile(ETypeFile.SER);
	}
	
	private void loadInfoTable(ETypeFile eTypeFile) {
		this.mainwindow.getHandlingPersitenceContact().setListContacts(new ArrayList<>());
		this.mainwindow.getHandlingPersitenceContact().loadFile(eTypeFile);
		this.clearTable();
		this.mainwindow.getHandlingPersitenceContact().getListContacts().forEach(contact -> {
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
