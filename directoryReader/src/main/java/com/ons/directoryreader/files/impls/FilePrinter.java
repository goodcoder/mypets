package com.ons.directoryreader.files.impls;

import java.io.File;

import org.springframework.stereotype.Service;

import com.ons.directoryreader.constants.FileConstants;
import com.ons.directoryreader.files.interfaces.IFilePrinter;
import com.ons.directoryreader.utils.FileUtils;


/**
 * @author Shekhar Arya
 * This class is used to send the output to various output formats. 
 *
 */
@Service  // @Service is better Annotation ten @Component for Business logic beans. @Component is higher level annotation.
public class FilePrinter implements IFilePrinter {
	
	private int filePathLength;
	
	/* (non-Javadoc)
	 * Formats and displays the Input file name and send to standard console for display.
	 * @see com.teksystems.directoryreader.files.interfaces.IFilePrinter#printFileOnconsole(java.io.File, int)
	 */
	@Override
	public  String printFileOnconsole(File file, int tabs) {
		String fileName = file.getName();
		String[] split = fileName.split(FileConstants.DELIMETER);
		
		FileUtils.printTabs(tabs);
		String outPut = "- Document: " + file.getName() + " - Extension: ." + split[split.length - 1] + " - URL: "
				+ file.getAbsolutePath().substring(filePathLength);
		System.out.println(outPut);
		return outPut;
	}

	

	

}
