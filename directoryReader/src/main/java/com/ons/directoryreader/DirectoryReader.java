package com.ons.directoryreader;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ons.directoryreader.files.impls.FilePrinter;
import com.ons.directoryreader.files.impls.FileSorter;
import com.ons.directoryreader.utils.FileUtils;

/**
 * @author Shekhar Arya
 * This class is used to traverse the file structure recursively.
 */
public class DirectoryReader  {
	
	private int directoryFilePathLength;
	
	@Autowired
	private FileSorter fileSorter;
	
	@Autowired
	private FilePrinter filePrinter;
	
	public DirectoryReader(int directoryFilePathLength) {
		this.directoryFilePathLength = directoryFilePathLength;
	}
	
	/**
	 * This method traverses the path of input file object. If it's a directory it prints it's path message.
	 * If its directory and contains child files , then it sorts the and traverse them recursively.
	 * Input parameter 'tabs' is used to indent the out put.
	 * @param File dir
	 * @param int tabs
	 */
	public void listAllFilesRecursively(File dir, int tabs) {

		if (null != dir) {
			if (dir.isDirectory()) {
				FileUtils.printTabs(tabs);
				System.out.println("- Project: " + dir.getName() + " - URL: "
						+ dir.getAbsolutePath().substring(directoryFilePathLength));
				String listOfFileNames[] = dir.list();
				List<String> sortedListOfFiles = fileSorter.sortFilesByExtensions(listOfFileNames);
				iterateListOfFiles(sortedListOfFiles, tabs, dir);
			} else {
				System.out.println("Please provide a path to root directory");
			}
		} else {
			System.out.println(dir + " is not a directory");
		}

	}
	
	/**
	 * Iterate directory and sub directory
	 *
	 * @param sortedListOfFiles
	 * @param tabs
	 * @param dir
	 */
	public void iterateListOfFiles(List<String> sortedListOfFiles, int tabs, File dir) {
		for (String item : sortedListOfFiles) {
			tabs++;
			File file = new File(dir + "/" + item);
			if (file.isDirectory()) {
				listAllFilesRecursively(file, tabs);
				tabs--;
			} else {
				filePrinter.printFileOnconsole(file, tabs);
				tabs--;
			}
		}
	}

}