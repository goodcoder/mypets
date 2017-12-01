package com.ons.directoryreader.tests;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ons.directoryreader.DirectoryReader;

/**
 * @author Shekhar Arya
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml" })
public class DirectoryReaderTest {
	@Autowired
	ApplicationContext context;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			File rootDirectory = new File("./testdirectory/Main Project");
			int directoryFilePathLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
			DirectoryReader  directoryReader = (DirectoryReader)context.getBean("directoryReader" , directoryFilePathLength);
			directoryReader.listAllFilesRecursively(rootDirectory, 0);
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			
			Assert.fail();
		}
		
	}
	
	

}
