package com.edu.uptc.handlingcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEventsMainWindow implements ActionListener {
	
	public static final String LOAD_CONTACT_PLAIN = "LOAD_CONTACT_PLAIN";

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(LOAD_CONTACT_PLAIN)) {
			System.out.println("Presionó click cargue archivo plano!");
		}
	}

}
