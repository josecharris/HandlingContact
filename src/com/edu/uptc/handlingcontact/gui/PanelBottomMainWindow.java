package com.edu.uptc.handlingcontact.gui;

import java.awt.FlowLayout;

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
		this.btnSortTable = new JButton("Ordenar tabla");
		this.btnClearTable = new JButton("Limpiar registros repetidos");
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
