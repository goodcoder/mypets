package com.ons.directoryreader.files.interfaces;

import java.io.File;

public interface IFilePrinter {
	
	/**
	 * This method prints directory and files on console
	 *
	 * @param file
	 * @param tabs
	 * @return 
	 */
	public abstract String printFileOnconsole(File file, int tabs);

}