package com.edu.uptc.handlingcontact.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PanelMiddleMainWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel dtm;
	private JTable table;
	private MainWindow mainWindow;
	
	public PanelMiddleMainWindow(MainWindow mainWindow) {
		setLayout(new GridLayout(1, 1));
		setBorder(new EmptyBorder(40, 10, 10, 10));
		this.mainWindow = mainWindow;
		this.buildComponents();
		this.addComponents();
	}
	
	
	private void buildComponents() {
		String[] titles = {"Código " , "Nombre " , "Número teléfono", "Email"};
		dtm = new DefaultTableModel(titles, 0);
		table = new JTable(dtm);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					 int fila = table.getSelectedRow();
					 //String nombre = table.getValueAt(fila, 1).toString();
					 mainWindow.getPanelRightMainWindow().setVisible(true);
				}
			}
		});
	}
	
	public void setDefaultTableModel(String[] titles) {
		dtm = new DefaultTableModel(titles, 0);
		this.table.setModel(dtm);
	}
	
	private void addComponents() {
		this.add(new JScrollPane(table));	
	}
	
	public void addRow(Object[] row) {
		dtm.addRow(row);
	}


	public DefaultTableModel getDtm() {
		return dtm;
	}


	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}


	public JTable getTable() {
		return table;
	}
	

	public void setTable(JTable table) {
		this.table = table;
	}
	

}
