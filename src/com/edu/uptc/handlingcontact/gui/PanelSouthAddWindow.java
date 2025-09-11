package com.edu.uptc.handlingcontact.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSouthAddWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnAccept;
	
	public PanelSouthAddWindow() {
		setLayout(new FlowLayout());
		this.btnBack = new JButton("Volver");
		this.btnAccept = new JButton("Aceptar");
		this.add(btnBack);
		this.add(btnAccept);
	}

}
