package com.edu.uptc.handlingcontact.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMiddleAddContactWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblCode;
	private JLabel lblName;
	private JLabel lblPhoneNumber;
	private JLabel lblEmail;
	private JLabel lblAddress;
	private JLabel lblIpAddress;
	
	private StyledTextField inputCode;
	private StyledTextField inputName;
	private StyledTextField inputPhoneNumber;
	private StyledTextField inputEmail;
	private StyledTextField inputAddress;
	private StyledTextField inputIpAddress;
	
	public PanelMiddleAddContactWindow() {
		setLayout(new GridLayout(12, 1));
		this.lblCode = new JLabel("Código");
		this.lblName = new JLabel("Nombre");
		this.lblPhoneNumber = new JLabel("Número de teléfono");
		this.lblEmail = new JLabel("Correo electrónico");
		this.lblAddress = new JLabel("Dirección de residencia");
		this.lblIpAddress = new JLabel("Dirección IP Asociada");
		
		this.inputCode = new StyledTextField(Boolean.FALSE);
		this.inputName = new StyledTextField(Boolean.FALSE);
		this.inputPhoneNumber = new StyledTextField(Boolean.FALSE);
		this.inputEmail = new StyledTextField(Boolean.FALSE);
		this.inputAddress = new StyledTextField(Boolean.FALSE);
		this.inputIpAddress = new StyledTextField(Boolean.FALSE);
	}

}
