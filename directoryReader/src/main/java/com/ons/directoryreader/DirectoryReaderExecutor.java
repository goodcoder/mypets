package com.ons.directoryreader;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The purpose of this utility is to read and print all the file names under
 * parent directory and all it's subdirectories recursively. The project is
 * working code based on Maven and Java 8. The candidates are supposed to
 * re-factor this utility using good OO principles e.g. Single responsibility
 * principle, interface segregation and code readability. Besides this proper
 * exception handling should also be implemented when make sense. All the code
 * should be and must be backed by unit testing. Note: the code can be imported
 * and run in any ide, but when candidates submit the code, they are supposed to
 * take all the ide specific code out and submit the project as a zip file with
 * candidate first name and last name as the file name. To run: mvn package and
 * then mvn exec:java
 *
 * @author rjilani
 */
public class DirectoryReaderExecutor {
	
	/**
	 * Main driver and entry point.
	 * Reads the files/directory from path provided and sends further to DirectoryReader object to process further.
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
		File rootDirectory = new File("./testdirectory/Main Project");
		int directoryFilePathLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
		DirectoryReader  directoryReader = (DirectoryReader)context.getBean("directoryReader" , directoryFilePathLength);
		directoryReader.listAllFilesRecursively(rootDirectory, 0);
	}


}
