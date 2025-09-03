package com.edu.uptc.handlingcontact.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LoginWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelLeftLoginWindow panelLeftLoginWindow;
	private PanelRightLoginWindow panelRightLoginWindow;
	
	public LoginWindow() {
		this.initComponents();
		this.addComponents();
	}
	
	private void initComponents() {
		setUpScreen();
		initializeComponent();
	}

	private void setUpScreen() {
		/* Agregar tamaño */
		setSize(800, 400);
		
		/* Centralizar pantalla */
		setLocationRelativeTo(null);
		
		/* Asignación de operación de cierre */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Asignación del coordinador LAYOUT */
		setLayout(new BorderLayout());
		
		/* Que no se pueda redimensionar */
		setResizable(false);
	}
	
	private void initializeComponent() {
		/* Definición de componentes */
		this.panelLeftLoginWindow = new PanelLeftLoginWindow();
		this.panelRightLoginWindow = new PanelRightLoginWindow();
	}
	
	private void addComponents() {
		/* Adición de componentes */
		this.add(panelLeftLoginWindow, BorderLayout.WEST);
		this.add(panelRightLoginWindow, BorderLayout.EAST);
	}
	
	public PanelLeftLoginWindow getPanelLeftLoginWindow() {
		return panelLeftLoginWindow;
	}
	public void setPanelLeftLoginWindow(PanelLeftLoginWindow panelLeftLoginWindow) {
		this.panelLeftLoginWindow = panelLeftLoginWindow;
	}
	public PanelRightLoginWindow getPanelRightLoginWindow() {
		return panelRightLoginWindow;
	}
	public void setPanelRightLoginWindow(PanelRightLoginWindow panelRightLoginWindow) {
		this.panelRightLoginWindow = panelRightLoginWindow;
	}
	
	public static void main(String[] args) {
		LoginWindow login = new LoginWindow();
		login.setVisible(true);
	}

}
