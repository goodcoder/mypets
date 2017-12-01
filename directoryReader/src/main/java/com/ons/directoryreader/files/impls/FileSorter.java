package com.ons.directoryreader.files.impls;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.ons.directoryreader.constants.FileConstants;
import com.ons.directoryreader.files.interfaces.IFileSorter;


/**
 * @author Shekhar Arya
 * 
 * File containing file sorting utility functions
 *
 */
@Service
public class FileSorter implements IFileSorter {
	
	/* (non-Javadoc)
	 * Takes and array of filenames and sort the on bases of their file extensions.
	 * @see com.teksystems.directoryreader.files.interfaces.IFileSorter#sortFilesByExtensions(java.lang.String[])
	 */
	@Override
	public  List<String> sortFilesByExtensions(String[] listOfFileNames) {
		List<String> orginalList = new CopyOnWriteArrayList<>(Arrays.asList(listOfFileNames));
		Set<String> setOfuniqueExtension = new TreeSet<>();

		for (String item : listOfFileNames) {
			if (item.contains(".")) {
				String[] split = item.split(FileConstants.DELIMETER);
				String temp = "." + split[split.length - 1];
				setOfuniqueExtension.add(temp);
			}
		}

		List<String> finalListOfAllFiles = new LinkedList<>();
		setOfuniqueExtension.stream().forEach((s1) -> {
			for (int i = 0; i < orginalList.size(); i++) {
				if (orginalList.get(i).contains(s1)) {
					finalListOfAllFiles.add(orginalList.get(i));
					orginalList.remove(orginalList.get(i));
					i--;
				}
			}
		});

		orginalList.stream().filter((s1) -> (!finalListOfAllFiles.contains(s1))).forEach((s1) -> {
			finalListOfAllFiles.add(s1);
		});

		return finalListOfAllFiles;
	}

	

}
