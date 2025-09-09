package com.edu.uptc.handlingcontact.gui;

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
	
	public OptionsBar() {
		this.optMenuHandlinContact = new JMenu("Administrar Contacto");
		this.optImport = new JMenu("Importar");
		this.optExport = new JMenu("Exportar");
		this.optReport = new JMenu("Informes");
		this.optCreateContact = new JMenuItem("Crear contacto");
		this.optUpdateContact = new JMenuItem("Actualizar contacto");
		this.optFindContactByCode = new JMenuItem("Buscar contacto");
		
		this.optImportPlain = new JMenuItem("Archivo plano");
		/* Se le asigna el evento al importado de archivo plano */
		this.optImportPlain.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_PLAIN);
		this.optImportPlain.addActionListener(new HandlingEventsMainWindow());
		
		this.optImportCSV = new JMenuItem("CSV");
		this.optImportXML = new JMenuItem("XML");
		this.optImportJSON = new JMenuItem("JSON");
		this.optImportSer = new JMenuItem("Serializado");
		
		this.optExportPlain = new JMenuItem("Archivo plano");
		this.optExportCSV = new JMenuItem("CSV");
		this.optExportXML = new JMenuItem("XML");
		this.optExportJSON = new JMenuItem("JSON");
		this.optExportSer = new JMenuItem("Serializado");
		
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
