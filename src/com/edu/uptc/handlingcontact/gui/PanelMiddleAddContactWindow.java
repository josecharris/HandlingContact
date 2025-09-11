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
		this.lblCode = new JLabel("C�digo");
		this.lblName = new JLabel("Nombre");
		this.lblPhoneNumber = new JLabel("N�mero de tel�fono");
		this.lblEmail = new JLabel("Correo electr�nico");
		this.lblAddress = new JLabel("Direcci�n de residencia");
		this.lblIpAddress = new JLabel("Direcci�n IP Asociada");
		
		this.inputCode = new StyledTextField(Boolean.FALSE);
		this.inputName = new StyledTextField(Boolean.FALSE);
		this.inputPhoneNumber = new StyledTextField(Boolean.FALSE);
		this.inputEmail = new StyledTextField(Boolean.FALSE);
		this.inputAddress = new StyledTextField(Boolean.FALSE);
		this.inputIpAddress = new StyledTextField(Boolean.FALSE);
	}

}
