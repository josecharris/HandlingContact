package com.edu.uptc.handlingcontact.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private OptionsBar optionBar;
	private PanelNorthMainWindow panelNorthMainWindow;
	private PanelMiddleMainWindow panelMiddleMainWindow;
	private PanelBottomMainWindow panelBottomMainWindow;
	private PanelRightMainWindow panelRightMainWindow;
	
	/* Definimos la pantalla auxiliar */
	private AddContactWindow addContactWindow;
	
	/* Clase que va a manejar los eventos de todos los paneles */
	private HandlingEventsMainWindow handlingEventsMainWindow;
	
	public MainWindow() {
		setSize(1024, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.handlingEventsMainWindow = new HandlingEventsMainWindow(this);
		
		this.optionBar = new OptionsBar(this);
		this.panelNorthMainWindow = new PanelNorthMainWindow();
		this.panelMiddleMainWindow = new PanelMiddleMainWindow(this);
		this.panelBottomMainWindow = new PanelBottomMainWindow();
		this.panelRightMainWindow = new PanelRightMainWindow(this);
		this.panelRightMainWindow.setVisible(false);
		
		/* Asignación de JMenu*/
		this.setJMenuBar(optionBar);
		this.add(panelNorthMainWindow, BorderLayout.NORTH);
		this.add(this.panelMiddleMainWindow, BorderLayout.CENTER);
		this.add(panelBottomMainWindow, BorderLayout.SOUTH);
		this.add(panelRightMainWindow, BorderLayout.EAST);
		
		this.addContactWindow = new AddContactWindow();
	}
	
	public OptionsBar getOptionBar() {
		return optionBar;
	}

	public void setOptionBar(OptionsBar optionBar) {
		this.optionBar = optionBar;
	}
	
	public PanelNorthMainWindow getPanelNorthMainWindow() {
		return panelNorthMainWindow;
	}

	public void setPanelNorthMainWindow(PanelNorthMainWindow panelNorthMainWindow) {
		this.panelNorthMainWindow = panelNorthMainWindow;
	}

	public PanelMiddleMainWindow getPanelMiddleMainWindow() {
		return panelMiddleMainWindow;
	}

	public void setPanelMiddleMainWindow(PanelMiddleMainWindow panelMiddleMainWindow) {
		this.panelMiddleMainWindow = panelMiddleMainWindow;
	}

	public PanelBottomMainWindow getPanelBottomMainWindow() {
		return panelBottomMainWindow;
	}

	public void setPanelBottomMainWindow(PanelBottomMainWindow panelBottomMainWindow) {
		this.panelBottomMainWindow = panelBottomMainWindow;
	}
	
	public PanelRightMainWindow getPanelRightMainWindow() {
		return panelRightMainWindow;
	}

	public void setPanelRightMainWindow(PanelRightMainWindow panelRightMainWindow) {
		this.panelRightMainWindow = panelRightMainWindow;
	}

	public AddContactWindow getAddContactWindow() {
		return addContactWindow;
	}

	public void setAddContactWindow(AddContactWindow addContactWindow) {
		this.addContactWindow = addContactWindow;
	}
	
	public HandlingEventsMainWindow getHandlingEventsMainWindow() {
		return handlingEventsMainWindow;
	}


	public static void main(String[] args) {
		MainWindow main = new MainWindow();
		main.setVisible(true);
	}

}
