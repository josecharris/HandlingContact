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
	
	public MainWindow() {
		setSize(1024, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.optionBar = new OptionsBar(this);
		this.panelNorthMainWindow = new PanelNorthMainWindow();
		this.panelMiddleMainWindow = new PanelMiddleMainWindow();
		this.panelBottomMainWindow = new PanelBottomMainWindow();
		this.panelRightMainWindow = new PanelRightMainWindow();
		/* Asignación de JMenu*/
		this.setJMenuBar(optionBar);
		this.add(panelNorthMainWindow, BorderLayout.NORTH);
		this.add(this.panelMiddleMainWindow, BorderLayout.CENTER);
		this.add(panelBottomMainWindow, BorderLayout.SOUTH);
		this.add(panelRightMainWindow, BorderLayout.EAST);
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





	public static void main(String[] args) {
		MainWindow main = new MainWindow();
		main.setVisible(true);
	}

}
