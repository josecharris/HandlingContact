package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		/* Se asigna un color de background */
		this.setBackground(Color.WHITE);
		
		/* Le asigno unos margenes*/
		this.setBorder(new EmptyBorder(10, 35, 10, 35));
		
		setLayout(new GridLayout(14, 1));
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
		
		this.add(this.lblCode);
		this.add(this.inputCode);
		this.add(this.lblName);
		this.add(this.inputName);
		this.add(this.lblPhoneNumber);
		this.add(this.inputPhoneNumber);
		this.add(this.lblEmail);
		this.add(this.inputEmail);
		this.add(this.lblAddress);
		this.add(this.inputAddress);
		this.add(this.lblIpAddress);
		this.add(this.inputIpAddress);
	}

	public JLabel getLblCode() {
		return lblCode;
	}

	public void setLblCode(JLabel lblCode) {
		this.lblCode = lblCode;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblPhoneNumber() {
		return lblPhoneNumber;
	}

	public void setLblPhoneNumber(JLabel lblPhoneNumber) {
		this.lblPhoneNumber = lblPhoneNumber;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblAddress() {
		return lblAddress;
	}

	public void setLblAddress(JLabel lblAddress) {
		this.lblAddress = lblAddress;
	}

	public JLabel getLblIpAddress() {
		return lblIpAddress;
	}

	public void setLblIpAddress(JLabel lblIpAddress) {
		this.lblIpAddress = lblIpAddress;
	}

	public StyledTextField getInputCode() {
		return inputCode;
	}

	public void setInputCode(StyledTextField inputCode) {
		this.inputCode = inputCode;
	}

	public StyledTextField getInputName() {
		return inputName;
	}

	public void setInputName(StyledTextField inputName) {
		this.inputName = inputName;
	}

	public StyledTextField getInputPhoneNumber() {
		return inputPhoneNumber;
	}

	public void setInputPhoneNumber(StyledTextField inputPhoneNumber) {
		this.inputPhoneNumber = inputPhoneNumber;
	}

	public StyledTextField getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(StyledTextField inputEmail) {
		this.inputEmail = inputEmail;
	}

	public StyledTextField getInputAddress() {
		return inputAddress;
	}

	public void setInputAddress(StyledTextField inputAddress) {
		this.inputAddress = inputAddress;
	}

	public StyledTextField getInputIpAddress() {
		return inputIpAddress;
	}

	public void setInputIpAddress(StyledTextField inputIpAddress) {
		this.inputIpAddress = inputIpAddress;
	}
	
	

}
