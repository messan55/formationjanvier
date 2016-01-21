package com.loncoto.myFirstTDD.util;

import java.io.File;
import java.util.Optional;

import com.loncoto.myFirstTDD.AppTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileStoreManagerTest extends TestCase {
	
	public FileStoreManagerTest() {
		super("test du file Store Manager");
	}
	
	public void testFileStoreManager()
	{
		FileStoreManager fsm = new FileStoreManager();
		
/*		String expectedValue = "c:\\images";
		String resultValue = null;
		
		fsm.setStorageRoot(new File(expectedValue));
		
		resultValue = fsm.getStorageRoot().getAbsolutePath();
		
		assertEquals("should be the same directory name", expectedValue, resultValue);
	*/	
	    //assertTrue("should be true and not false",  false);
		
		
		
		fsm.setStorageRoot(new File("c:\\fsm"));
		
		File f = new File("c:\\partage\\binding-angular.txt");
		fsm.saveFile("testentite", 4, f);
		Optional<File> actualValue = fsm.getFile("testentite", 4);
		assertTrue(actualValue.isPresent());
		
		
	}
	
	public static Test suite()
	{
        return new TestSuite( FileStoreManagerTest.class );
	}
}
