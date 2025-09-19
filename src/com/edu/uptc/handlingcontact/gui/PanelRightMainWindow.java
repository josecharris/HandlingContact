package com.edu.uptc.handlingcontact.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelRightMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnSeeMore;
	private JButton btnUpdate;
	private JButton btnDelete;
	private MainWindow mainWindow;
	
	public PanelRightMainWindow(MainWindow mainWindow) {
		setBorder(new EmptyBorder(200, 15, 0, 15));
		setLayout(new GridLayout(14, 1));
		this.mainWindow = mainWindow;
		this.btnSeeMore = new JButton("Ver más");
		this.btnSeeMore.setActionCommand(HandlingEventsMainWindow.SEE_MORE_CONTACT);
		this.btnSeeMore.addActionListener(mainWindow.getHandlingEventsMainWindow());
		
		this.btnUpdate = new JButton("Actualizar");
		this.btnUpdate.setActionCommand(HandlingEventsMainWindow.UPDATE_CONTACT);
		this.btnUpdate.addActionListener(mainWindow.getHandlingEventsMainWindow());
		
		this.btnDelete = new JButton("Eliminar");
		this.btnDelete.setActionCommand(HandlingEventsMainWindow.DELETE_CONTACT);
		this.btnDelete.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.add(btnSeeMore);
		this.add(btnUpdate);
		this.add(btnDelete);
	}

	public JButton getBtnSeeMore() {
		return btnSeeMore;
	}

	public void setBtnSeeMore(JButton btnSeeMore) {
		this.btnSeeMore = btnSeeMore;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	

}
