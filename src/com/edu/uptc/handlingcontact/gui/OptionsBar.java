package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OptionsBar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	/* Definición de los JMenu*/
	private JMenu optMenuHandlinContact;
	private JMenu optImport;
	private JMenu optExport;
	private JMenu optReport;
	
	private JMenuItem optCreateContact;
	private JMenuItem optUpdateContact;
	private JMenuItem optFindContactByCode;
	
	private JMenuItem optImportPlain;
	private JMenuItem optImportCSV;
	private JMenuItem optImportXML;
	private JMenuItem optImportJSON;
	private JMenuItem optImportSer;
	
	private JMenuItem optExportPlain;
	private JMenuItem optExportCSV;
	private JMenuItem optExportXML;
	private JMenuItem optExportJSON;
	private JMenuItem optExportSer;
	
	private MainWindow mainWindow;
	
	public OptionsBar(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.setBackground(Color.WHITE);
		this.optMenuHandlinContact = new JMenu("Administrar Contacto");
		this.optMenuHandlinContact.setIcon(new ImageIcon("resources/img/icons/handlingContact.png"));
		this.optImport = new JMenu("Importar");
		this.optImport.setIcon(new ImageIcon("resources/img/icons/load.png"));
		this.optExport = new JMenu("Exportar");
		this.optExport.setIcon(new ImageIcon("resources/img/icons/dump.png"));
		this.optReport = new JMenu("Informes");
		this.optReport.setIcon(new ImageIcon("resources/img/icons/reports.png"));
		
		
		this.optCreateContact = new JMenuItem("Crear contacto");
		/* Asignar el evento */
		this.optCreateContact.setIcon(new ImageIcon("resources/img/icons/addUser.png"));
		this.optCreateContact.setActionCommand(HandlingEventsMainWindow.ADD_CONTACT);
		this.optCreateContact.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		
		this.optUpdateContact = new JMenuItem("Actualizar contacto");
		this.optUpdateContact.setIcon(new ImageIcon("resources/img/icons/updateUser.png"));
		
		this.optFindContactByCode = new JMenuItem("Buscar contacto");
		this.optFindContactByCode.setIcon(new ImageIcon("resources/img/icons/findUser.png"));
		
		this.optImportPlain = new JMenuItem("Archivo plano");
		/* Se le asigna el evento al importado de archivo plano */
		this.optImportPlain.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_PLAIN);
		this.optImportPlain.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
		
		this.optImportCSV = new JMenuItem("CSV");
		this.optImportCSV.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_CSV);
		this.optImportCSV.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		
		this.optImportXML = new JMenuItem("XML");
		this.optImportXML.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_XML);
		this.optImportXML.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		
		this.optImportJSON = new JMenuItem("JSON");
		this.optImportJSON.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_JSON);
		this.optImportJSON.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		
		this.optImportSer = new JMenuItem("Serializado");
		this.optImportSer.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_SERIALIZATE);
		this.optImportSer.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportSer.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));
		
		this.optExportPlain = new JMenuItem("Archivo plano");
		this.optExportPlain.setActionCommand(HandlingEventsMainWindow.EXPORT_CONTACT_FILE_PLAIN);
		this.optExportPlain.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optExportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
		
		this.optExportCSV = new JMenuItem("CSV");
		this.optExportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		
		this.optExportXML = new JMenuItem("XML");
		this.optExportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		
		this.optExportJSON = new JMenuItem("JSON");
		this.optExportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		
		this.optExportSer = new JMenuItem("Serializado");
		this.optExportSer.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));
		
		this.optMenuHandlinContact.add(this.optCreateContact);
		this.optMenuHandlinContact.add(this.optUpdateContact);
		this.optMenuHandlinContact.add(this.optFindContactByCode);
		
		this.optImport.add(this.optImportPlain);
		this.optImport.add(this.optImportCSV);
		this.optImport.add(this.optImportXML);
		this.optImport.add(this.optImportJSON);
		this.optImport.add(this.optImportSer);
		
		this.optExport.add(this.optExportPlain);
		this.optExport.add(this.optExportCSV);
		this.optExport.add(this.optExportXML);
		this.optExport.add(this.optExportJSON);
		this.optExport.add(this.optExportSer);
		
		this.add(optMenuHandlinContact);
		this.add(optImport);
		this.add(optExport);
		this.add(optReport);
	}

}
