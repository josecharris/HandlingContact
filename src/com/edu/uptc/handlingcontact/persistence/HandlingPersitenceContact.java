package com.edu.uptc.handlingcontact.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.edu.uptc.handlingcontact.constants.CommonConstants;
import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.interfaces.IActionsFile;
import com.edu.uptc.handlingcontacts.model.Contact;

public class HandlingPersitenceContact extends FilePlain implements IActionsFile{

	public static String CODE_CONTACT_SELECTED = "";
	private List<Contact> listContacts;
	
	public HandlingPersitenceContact() {
		this.listContacts = new ArrayList<Contact>();
	}
	
	public Boolean addContact(Contact contact) {
		if(Objects.isNull(this.findContactById(contact.getCode()))) {
			this.listContacts.add(contact);
			return true;
		}
		return false;
	}
	
	private Contact findContactById(String code) {
		for(Contact contact: this.listContacts) {
			if(contact.getCode().equals(code)) {
				return contact;
			}
		}
		return null;
	}
	
	public Boolean deleteContact(String code) {
		int index = -1;
		for(int i=0; i<this.listContacts.size(); i++) {
			if(this.listContacts.get(i).getCode().equals(code)) {
				index = i;
			}
		}
		if(index == -1) {
			return false;
		}
		this.listContacts.remove(index);
		return true;
	}
	
	@Override
	public void loadFile(ETypeFile eTypeFile) {
		if(eTypeFile.equals(ETypeFile.FILE_PLAIN)) {
			String nameFile = config.getNameFileTXT();
			loadFilePlain(nameFile);
		}
		if(eTypeFile.equals(ETypeFile.CSV)) {
			String nameFile = config.getNameFileCSV();
			loadFilePlain(nameFile);
		}
		if(eTypeFile.equals(ETypeFile.JSON)) {
			this.loadFileJSON();
		}
		if(eTypeFile.equals(ETypeFile.XML)) {
			this.loadFileXML();
		}
		if(eTypeFile.equals(ETypeFile.SER)) {
			this.loadFileSerializate();
		}
	}
	
	private void loadFileXML() {
		try {
			File file = new File(config.getPathFiles().concat(config.getNameFileXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(
					CommonConstants.NAME_TAG_CONTACT);
			for (int i = 0; i < list.getLength(); i++) {
				String name = document.getElementsByTagName("name").item(i)
						.getTextContent();
				String code = document.getElementsByTagName("code").item(i)
						.getTextContent();
				String phoneNumber = document.getElementsByTagName("phoneNumber")
						.item(i).getTextContent();
				String email = document.getElementsByTagName("email").item(i)
						.getTextContent();
				String address = document.getElementsByTagName("address").item(i)
						.getTextContent();
				String idAddress = document.getElementsByTagName("idAddress")
						.item(i).getTextContent();
				this.listContacts.add(new Contact(code, name, phoneNumber, email, 
						address, idAddress));
			}
		}catch(Exception e) {
			System.out.println("Se presentó un error en el cargue del archivo XML");
		}
	}
	
	private void loadFileJSON() {
		List<String> contentInLine = this.reader(
				config.getPathFiles().concat(config.getNameFileJson()))
				.stream().filter(line -> !line.equals("[") && !line.equals("]") &&
						!line.equals(CommonConstants.BREAK_LINE) &&
						!line.trim().isEmpty() && !line.trim().isBlank())
				.collect(Collectors.toList());
		for(String line: contentInLine) {
			line = line.replace("{", "").replace("},", "").replace("}", "");
			StringTokenizer tokens = new StringTokenizer(line, ",");
			while(tokens.hasMoreElements()){
				String code = this.escapeValue(tokens.nextToken().split(":")[1]);
				String name = this.escapeValue(tokens.nextToken().split(":")[1]);
				String phoneNumber = this.escapeValue(tokens.nextToken().split(":")[1]);
				String email = this.escapeValue(tokens.nextToken().split(":")[1]);
				String address = this.escapeValue(tokens.nextToken().split(":")[1]);
				String idAddress = this.escapeValue(tokens.nextToken().split(":")[1]);
				this.listContacts.add(new Contact(code, name, 
						phoneNumber, email, address, idAddress));
			}
		}
	}
	
	private String escapeValue(String value) {
		return value.replace("\"", "");
	}
	
	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if(eTypeFile.equals(ETypeFile.FILE_PLAIN)) {
			String nameFile = config.getNameFileTXT();
			dumpFilePlain(nameFile);
		}
		if(eTypeFile.equals(ETypeFile.CSV)) {
			String nameFile = config.getNameFileCSV();
			dumpFilePlain(nameFile);
		}
		if(eTypeFile.equals(ETypeFile.JSON)) {
			dumpFileJSON();
		}
		if(eTypeFile.equals(ETypeFile.XML)) {
			dumpFileXML();
		}
		if(eTypeFile.equals(ETypeFile.SER)) {
			this.dumpFileSerializate();
		}
	}

	private void dumpFileXML() {
		String rutaArchivo = config.getPathFiles().concat(
				config.getNameFileXML());
		List<String> records = new ArrayList<>();
		records.add("<XML version=\"1.0\" encoding=\"UTF-8\">");
		for (Contact contact : this.listContacts) {
			records.add("<contact>");
			records.add("\t<name>"+contact.getName()+"</name>");
			records.add("\t<code>"+contact.getCode()+"</code>");
			records.add("\t<phoneNumber>"+contact.getPhoneNumber()+"</phoneNumber>");
			records.add("\t<email>"+contact.getEmail()+"</email>");
			records.add("\t<address>"+contact.getAddress()+"</address>");
			records.add("\t<idAddress>"+contact.getIpAddress()+"</idAddress>");
			records.add("</contact>");
		}
		records.add("</XML>");
		this.writer(rutaArchivo, records);
	}

	private void dumpFileJSON() {
		String rutaArchivo = config.getPathFiles()
				.concat(config.getNameFileJson());
	    StringBuilder json = null;
	    List<String> content = new ArrayList<String>();
	    content.add(CommonConstants.OPENING_BRACKET);
	    int contador = 0;
	    int total = listContacts.size();
	    for (Contact c : this.listContacts) {
	    	json = new StringBuilder();
	        json.append("{");
	        json.append("  \"code\":\"").append(escape(c.getCode())).append("\",");
	        json.append("  \"name\":\"").append(escape(c.getName())).append("\",");
	        json.append("  \"phoneNumber\":\"").append(escape(c.getPhoneNumber())).append("\",");
	        json.append("  \"email\":\"").append(escape(c.getEmail())).append("\",");
	        json.append("  \"address\":\"").append(escape(c.getAddress())).append("\",");
	        json.append("  \"ipAddress\":\"").append(escape(c.getIpAddress())).append("\"");
	        json.append("}");

	        contador++;
	        if (contador < total) {
	            json.append(",");
	        }
	        content.add(json.toString());
	    }
	    content.add("]");
	    this.writer(rutaArchivo, content);
	}
	
	/** Escapa comillas dobles y backslashes para que el JSON no se rompa */
	private String escape(String value) {
	    if (value == null) return "";
	    return value.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	private void loadFilePlain(String nameFile) {
		List<String> contentInLine = this.reader(
				config.getPathFiles().concat(
						nameFile));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(
					row, CommonConstants.SEMICOLON);
			while(tokens.hasMoreElements()){
				String code = tokens.nextToken();
				String name = tokens.nextToken();
				String phoneNumber = tokens.nextToken();
				String email = tokens.nextToken();
				String address = tokens.nextToken();
				String ipAddress = tokens.nextToken();
				this.listContacts.add(
						new Contact(code, name, phoneNumber, 
								email, address, ipAddress));
			}
		});
	}

	private void dumpFilePlain(String nameFile) {
		StringBuilder rutaArchivo = new StringBuilder();
		rutaArchivo.append(config.getPathFiles());
		rutaArchivo.append(nameFile);
		List<String> records = new ArrayList<>();
		for(Contact student : this.listContacts){
			StringBuilder contentStudent = new StringBuilder();
			contentStudent.append(student.getCode()).append(CommonConstants.SEMICOLON);
			contentStudent.append(student.getName()).append(CommonConstants.SEMICOLON);
			contentStudent.append(student.getPhoneNumber()).append(CommonConstants.SEMICOLON);
			contentStudent.append(student.getEmail()).append(CommonConstants.SEMICOLON);
			contentStudent.append(student.getAddress()).append(CommonConstants.SEMICOLON);
			contentStudent.append(student.getIpAddress());
			records.add(contentStudent.toString());
		}
		this.writer(rutaArchivo.toString(), records);
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(
				this.config.getPathFiles()
				.concat(this.config.getNameFileSer()));
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            out.writeObject(this.listContacts);
	    } catch (IOException i) {
	    	i.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.config.getPathFiles()
				.concat(this.config.getNameFileSer()));
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
			this.listContacts = (List<Contact>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
	    }
	}

	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<Contact> listContacts) {
		this.listContacts = listContacts;
	}
	
}
