package com.edu.uptc.handlingcontact.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelLeftLoginWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelLeftLoginWindow() {
		/* Asignaci�n del tama�o */
		setPreferredSize(new Dimension(300, getHeight()));
		/* Asignaci�n del color */
		setBackground(GUIUtils.getPrincipalColor());
	}

}
