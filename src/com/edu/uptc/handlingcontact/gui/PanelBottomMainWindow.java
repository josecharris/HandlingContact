package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelBottomMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnSortTable;
	private JButton btnClearTable;
	
	public PanelBottomMainWindow() {
		setLayout(new FlowLayout());
		setBorder(new EmptyBorder(0, 0, 20, 0));
		setBackground(Color.WHITE);
		this.btnSortTable = new JButton("Ordenar tabla");
		this.btnSortTable.setIcon(new ImageIcon("resources/img/icons/sort.png"));
		this.btnClearTable = new JButton("Limpiar registros repetidos");
		this.btnClearTable.setIcon(new ImageIcon("resources/img/icons/clean.png"));
		this.add(btnSortTable);
		this.add(btnClearTable);
	}

	public JButton getBtnSortTable() {
		return btnSortTable;
	}

	public void setBtnSortTable(JButton btnSortTable) {
		this.btnSortTable = btnSortTable;
	}

	public JButton getBtnClearTable() {
		return btnClearTable;
	}

	public void setBtnClearTable(JButton btnClearTable) {
		this.btnClearTable = btnClearTable;
	}
}
