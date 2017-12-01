package com.ons.directoryreader.files.interfaces;

import java.util.List;

public interface IFileSorter {

	/**
	 * This methods sort the list of files by extension
	 *
	 * @param listOfFileNames
	 * @return
	 */
	public abstract List<String> sortFilesByExtensions(String[] listOfFileNames);

}