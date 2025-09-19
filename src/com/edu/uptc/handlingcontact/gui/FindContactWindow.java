package com.edu.uptc.handlingcontact.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FindContactWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitle;
	private JLabel lblAttribute;
	private JComboBox<String> comboAttribute;
	private JLabel lblValue;
	private StyledTextField txtValue;
	private JButton btnBack;
	private JButton btnAccept;
	
	public FindContactWindow(MainWindow mainWindow) {
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(1, 1));
		panelNorth.setBorder(new EmptyBorder(15, 0, 0, 0));
		this.lblTitle = new JLabel("Búsqueda");
		this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorth.add(this.lblTitle);
		panelNorth.setBackground(Color.WHITE);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(6, 2));
		panelCenter.setBorder(new EmptyBorder(20, 50, 20, 50));
		panelCenter.setBackground(Color.WHITE);
		
		String[] opciones = new String[] {"CODIGO", "NOMBRE", "EMAIL", "DIRECCION", "DIRECCION IP"};
		this.lblAttribute = new JLabel("Seleccione el atributo: ");
		this.comboAttribute = new JComboBox<String>(opciones);
		this.lblValue = new JLabel("Ingrese el valor: ");
		this.txtValue = new StyledTextField(false);
		this.btnBack = new JButton("Volver");
		this.btnAccept = new JButton("Buscar");
		
		
		panelCenter.add(this.lblAttribute);
		panelCenter.add(this.comboAttribute);
		JPanel panelSeparator = new JPanel();
		panelSeparator.setBackground(Color.WHITE);
		panelCenter.add(panelSeparator);
		panelCenter.add(lblValue);
		panelCenter.add(txtValue);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout());
		
		btnAccept.setActionCommand(HandlingEventsMainWindow.FIND_CONTACT_BY_ATTRIBUTE);
		btnAccept.addActionListener(mainWindow.getHandlingEventsMainWindow());
		
		btnBack.setActionCommand(HandlingEventsMainWindow.HIDE_WINDOW_FIND_CONTACT);
		btnBack.addActionListener(mainWindow.getHandlingEventsMainWindow());
		
		panelSouth.add(btnBack);
		panelSouth.add(btnAccept);
		panelSouth.setBackground(Color.WHITE);
		
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JLabel getLblAttribute() {
		return lblAttribute;
	}

	public void setLblAttribute(JLabel lblAttribute) {
		this.lblAttribute = lblAttribute;
	}

	public JComboBox<String> getComboAttribute() {
		return comboAttribute;
	}

	public void setComboAttribute(JComboBox<String> comboAttribute) {
		this.comboAttribute = comboAttribute;
	}

	public JLabel getLblValue() {
		return lblValue;
	}

	public void setLblValue(JLabel lblValue) {
		this.lblValue = lblValue;
	}

	public StyledTextField getTxtValue() {
		return txtValue;
	}

	public void setTxtValue(StyledTextField txtValue) {
		this.txtValue = txtValue;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}
	
}
