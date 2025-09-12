package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSouthAddWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnAccept;
	
	public PanelSouthAddWindow() {
		setLayout(new FlowLayout());
		
		/* Le asigno unos margenes*/
		this.setBorder(new EmptyBorder(0, 0, 50, 0));
		
		/* Se asigna un color de background */
		this.setBackground(Color.WHITE);
		this.btnBack = new JButton("Volver");
		this.btnAccept = new JButton("Aceptar");
		this.add(btnBack);
		this.add(btnAccept);
	}

}
