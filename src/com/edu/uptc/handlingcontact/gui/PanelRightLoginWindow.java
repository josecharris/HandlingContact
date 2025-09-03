package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelRightLoginWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblUserName;
	private StyledTextField inputUserName;
	private JLabel lblPassword;
	private StyledTextField inputPassword;
	private JButton buttonLogin;
	private JLabel lblMessageError;
	
	public PanelRightLoginWindow() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(484, 70));
		setLayout(new GridLayout(12, 1));
		
		this.lblTitle = new JLabel("LOGIN CONTACTO");
		this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblUserName = new JLabel("Nombre de usuario:");
		this.inputUserName = new StyledTextField(Boolean.FALSE);
		this.lblPassword = new JLabel("Contraseña:");
		this.inputPassword = new StyledTextField(Boolean.TRUE);
		this.buttonLogin = new JButton("Aceptar");
		this.buttonLogin.setBackground(GUIUtils.getPrincipalColor());
		this.buttonLogin.setForeground(Color.WHITE);
		this.lblMessageError = new JLabel("El usuario no se encuentra registrado.");
		this.lblMessageError.setForeground(Color.RED);
		this.lblMessageError.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMessageError.setVisible(false);
		
		JPanel panelSeparator1 = new JPanel();
		panelSeparator1.setBackground(Color.WHITE);
		JPanel panelSeparator2 = new JPanel();
		panelSeparator2.setBackground(Color.WHITE);
		JPanel panelSeparator3 = new JPanel();
		panelSeparator3.setBackground(Color.WHITE);
		JPanel panelSeparator4 = new JPanel();
		panelSeparator4.setBackground(Color.WHITE);
		JPanel panelSeparator5 = new JPanel();
		panelSeparator5.setBackground(Color.WHITE);
		
		this.add(lblTitle);
		this.add(panelSeparator1);
		this.add(lblUserName);
		this.add(inputUserName);
		this.add(panelSeparator2);
		this.add(lblPassword);
		this.add(inputPassword);
		this.add(panelSeparator3);
		this.add(panelSeparator4);
		this.add(buttonLogin);
		this.add(panelSeparator5);
		this.add(lblMessageError);
	}
	

}
