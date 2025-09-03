package com.edu.uptc.handlingcontact.interfaces;

import com.edu.uptc.handlingcontact.enums.ETypeFile;

public interface IActionsFile {
	public void loadFile(ETypeFile eTypeFile);
	public void dumpFile(ETypeFile eTypeFile);
}
