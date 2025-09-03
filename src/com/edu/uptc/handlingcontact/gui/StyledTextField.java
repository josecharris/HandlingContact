package com.edu.uptc.handlingcontact.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class StyledTextField extends JPasswordField {
	private static final long serialVersionUID = 1L;
	private Boolean passwordMode;
	
	public StyledTextField() {
		
	}
	
	public StyledTextField(Boolean passwordMode) {
		this.passwordMode = passwordMode;
		
		/* Echo que muestra el texto plano */
		setEchoChar((char) 0);
        if (Boolean.TRUE.equals(passwordMode)) {
        	/* Echo que me oculta la informaci�n ingresada */
            setEchoChar('*');
        }
		this.initializeUI();
	}
	
	private void initializeUI() {
		/*
		 * try {
        	
			setFont(Font.createFont(Font.TRUETYPE_FONT, 
					new File("resources/fonts/roboto/Roboto-Regular.ttf"))
					.deriveFont(15f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
    	 * */
        setPreferredSize(new Dimension(250, 40));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY),
                new EmptyBorder(0, 10, 0, 0)
        ));
        setCaretColor(Color.BLACK);
    }

	public Boolean getPasswordMode() {
		return passwordMode;
	}

	public void setPasswordMode(Boolean passwordMode) {
		this.passwordMode = passwordMode;
	}
	

}
