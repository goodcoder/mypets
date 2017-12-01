package com.ons.directoryreader.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ons.directoryreader.files.interfaces.IFileSorter;

/**
 * @author Shekhar Arya
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml" })
public class FileSorterTest {
	@Autowired
	IFileSorter filesorter;
	String listOfFileNames[]  = {"fileD.ddd", "fileB.bbb", "fileC.ccc", "fileA.aaa"};
	
	/**
	 * This test takes an array of unsorted file names and test that they are sorted my file extension
	 */
	@Test
	public void test() {
		
		List<String> sortedFilesByExtensions = filesorter.sortFilesByExtensions(listOfFileNames);
		Assert.assertEquals(sortedFilesByExtensions.get(0), "fileA.aaa");
		Assert.assertEquals(sortedFilesByExtensions.get(1), "fileB.bbb");
		Assert.assertEquals(sortedFilesByExtensions.get(2), "fileC.ccc");
		Assert.assertEquals(sortedFilesByExtensions.get(3), "fileD.ddd");
		
	}

}
