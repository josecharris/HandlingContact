package com.edu.uptc.handlingcontact.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddContactWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private PanelMiddleAddContactWindow panelMiddleAddContactWindow;
	private PanelSouthAddWindow panelSouthAddWindow;

	public AddContactWindow(MainWindow mainWindow) {
		/* Tamaño */
		setSize(600, 750);
		/* Centrar */
		setLocationRelativeTo(null);
		/* Comportamiento por defecto */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		/* Que no fuera modificable */
		setResizable(false);
		
		/* Layout*/
		setLayout(new BorderLayout());
		this.panelMiddleAddContactWindow = new PanelMiddleAddContactWindow();
		this.panelSouthAddWindow = new PanelSouthAddWindow(mainWindow);
		
		JPanel panelNorth = new JPanel();
		
		this.lblTitle = new JLabel("Agregar Contacto");
		Font fontAux = lblTitle.getFont();
		Font fontTitle = new Font(fontAux.getName(), Font.BOLD, 24);
		this.lblTitle.setFont(fontTitle);
		panelNorth.setBorder(new EmptyBorder(15, 0, 15, 0));
		
		panelNorth.add(this.lblTitle);
		panelNorth.setBackground(Color.WHITE);
		
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(this.panelMiddleAddContactWindow, BorderLayout.CENTER);
		this.add(panelSouthAddWindow, BorderLayout.SOUTH);
	}


	public PanelMiddleAddContactWindow getPanelMiddleAddContactWindow() {
		return panelMiddleAddContactWindow;
	}


	public void setPanelMiddleAddContactWindow(PanelMiddleAddContactWindow panelMiddleAddContactWindow) {
		this.panelMiddleAddContactWindow = panelMiddleAddContactWindow;
	}


	public PanelSouthAddWindow getPanelSouthAddWindow() {
		return panelSouthAddWindow;
	}


	public void setPanelSouthAddWindow(PanelSouthAddWindow panelSouthAddWindow) {
		this.panelSouthAddWindow = panelSouthAddWindow;
	}


	public JLabel getLblTitle() {
		return lblTitle;
	}


	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}
	
}
