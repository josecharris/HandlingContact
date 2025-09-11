package com.edu.uptc.handlingcontact.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class AddContactWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private PanelSouthAddWindow panelSouthAddWindow;
	private JLabel lblTitle;

	public AddContactWindow() {
		/* Tamaño */
		setSize(600, 750);
		/* Centrar */
		setLocationRelativeTo(null);
		/* Comportamiento por defecto */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Que no fuera modificable */
		setResizable(false);
		/* Layout*/
		setLayout(new BorderLayout());
		
		this.panelSouthAddWindow = new PanelSouthAddWindow();
		this.lblTitle = new JLabel("Agregar Contacto");
		Font fontAux = lblTitle.getFont();
		Font fontTitle = new Font(fontAux.getName(), Font.BOLD, 24);
		this.lblTitle.setFont(fontTitle);
		this.lblTitle.setBorder(new EmptyBorder(15, 190, 15, 0));
		
		this.add(lblTitle, BorderLayout.NORTH);
		this.add(panelSouthAddWindow, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		AddContactWindow addContactWindow = new AddContactWindow();
		addContactWindow.setVisible(true);
	}
	
	
}
