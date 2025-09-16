package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSouthAddWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnAccept;
	private HandlingEventsAddWindow handlingEventsAddWindow;
	
	public PanelSouthAddWindow(AddContactWindow addContactWindow) {
		
		setLayout(new FlowLayout());
		
		/* Le asigno unos margenes*/
		this.setBorder(new EmptyBorder(0, 0, 50, 0));
		
		/* Se asigna un color de background */
		this.setBackground(Color.WHITE);
		this.btnBack = new JButton("Volver");
		this.btnBack.setIcon(new ImageIcon("resources/img/icons/back.png"));
		this.btnBack.setActionCommand(HandlingEventsAddWindow.GET_BACK);
		handlingEventsAddWindow = new HandlingEventsAddWindow(addContactWindow);
		this.btnBack.addActionListener(handlingEventsAddWindow);
		
		this.btnAccept = new JButton("Aceptar");
		this.btnAccept.setIcon(new ImageIcon("resources/img/icons/ok.png"));
		this.btnAccept.setActionCommand(HandlingEventsAddWindow.ADD_CONTACT);
		this.btnAccept.addActionListener(handlingEventsAddWindow);
		
		this.add(btnBack);
		this.add(btnAccept);
	}

}
