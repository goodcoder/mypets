package com.ons.directoryreader.tests;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ons.directoryreader.files.interfaces.IFilePrinter;

/**
 * @author Shekhar Arya
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml" })
public class FilePrinterTest {
	@Autowired
	IFilePrinter fileprinter;
	
	File file; 
	@Before
	public void setUp(){
		file = new File("TestFile.txt");
	}
	
	/**
	 * This test takes a file and display its file name details.
	 */
	@Test 
	public void test() {
		try {
			String printFileOnconsole = fileprinter.printFileOnconsole(file, 1) ;
			Assert.assertEquals("- Document: TestFile.txt - Extension: .txt - URL: "+System.getProperty("user.dir")+"\\TestFile.txt", printFileOnconsole.toString());
		} catch (Exception e) {
			Assert.fail();
		}
           
	}
	
	@After
	public void tearDown(){
	}

}
