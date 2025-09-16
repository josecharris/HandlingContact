package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelNorthMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleMainWindow;
	private JButton btnFindBy;
	
	public PanelNorthMainWindow() {
		setBackground(Color.WHITE);
		this.lblTitleMainWindow = new JLabel("ADMINISTRACIÓN DE CONTACTOS");
		Font actualFont = this.lblTitleMainWindow.getFont();
		Font fontTitle = new Font(actualFont.getName(), Font.BOLD, 24);
		
		this.setBorder(new EmptyBorder(20, 0, 0, 0));
		this.btnFindBy = new JButton("Buscar por:");
		this.btnFindBy.setIcon(new ImageIcon("resources/img/icons/findBy.png"));
		this.lblTitleMainWindow.setFont(fontTitle);
		this.lblTitleMainWindow.setBorder(new EmptyBorder(0, 30, 0, 80));
		this.setLayout(new FlowLayout());
		this.add(this.lblTitleMainWindow);
		this.add(btnFindBy);
	}
}
