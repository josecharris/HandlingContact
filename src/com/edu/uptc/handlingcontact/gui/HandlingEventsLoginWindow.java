package com.edu.uptc.handlingcontact.gui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.edu.uptc.handlingcontact.enums.ETypeFile;
import com.edu.uptc.handlingcontact.persistence.HandlingPersistenseUser;

public class HandlingEventsLoginWindow implements ActionListener {
	
	public static final String VALIDATE_LOGIN = "VALIDATE_LOGIN";
	private PanelRightLoginWindow panelRightLoginWindow;
	private HandlingPersistenseUser handlingPersistenseUser;
	
	public HandlingEventsLoginWindow(PanelRightLoginWindow panelRightLoginWindow) {
		this.panelRightLoginWindow = panelRightLoginWindow;
		this.handlingPersistenseUser = new HandlingPersistenseUser();
		this.handlingPersistenseUser.loadFile(ETypeFile.SER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case VALIDATE_LOGIN:
				String nameuser = this.panelRightLoginWindow.getInputUserName().getText();
				String password = this.panelRightLoginWindow.getInputPassword().getText();
				
				if(Boolean.TRUE.equals(this.handlingPersistenseUser.findUserByUsernamePassword(nameuser, password))) {
					Window ventana = SwingUtilities.getWindowAncestor(this.panelRightLoginWindow);
		            if (ventana != null) {
		            	/* Oculta la vista del login */
		                ventana.setVisible(false);
		                
		                /* Muestra la vista principal */
		                this.panelRightLoginWindow.getMainWindow().setVisible(true);
		                this.panelRightLoginWindow.getLblMessageError().setVisible(false);
		            }
				}else {
					this.panelRightLoginWindow.getLblMessageError().setVisible(true);
				}
				break;
		}
	}

}
