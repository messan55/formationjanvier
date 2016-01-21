package com.loncoto.myFirstTDD.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;

import com.loncoto.myFirstTDD.AppTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileStoreManagerTest extends TestCase {
	
	public FileStoreManagerTest() {
		super("test du file Store Manager");
	}
	
	public void testSaveAndGet()
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
		/*
		File f = new File("c:\\partage\\binding-angular.txt");
		fsm.saveFile("testentite", 4, f);
		Optional<File> actualValue = fsm.getFile("testentite", 4);
		assertTrue(actualValue.isPresent());
		*/
		try {
			// getClass().getRessource vous permet de récupérer les ressources
			// associée a notre classe, ce qui concretement correspond
			// au fichiers présent dans notre package, c.a.d dans le meme répertoire
			// que notre classe
			
			// quand maven compile un fichier java -> .class -> target/<packagedirectory>
		
			File f = new File(getClass().getResource("testFile.txt").toURI());
			fsm.saveFile("testentite", 4, f);
			Optional<File> actualValue = fsm.getFile("testentite", 4);
			assertTrue("le fichier n'a pas été retrouvé",actualValue.isPresent());
			
			StringBuilder sb = new StringBuilder();
			Scanner reader = new Scanner(f);
			while (reader.hasNext()) {
				sb.append(reader.next());
			}
			
			StringBuilder sb2 = new StringBuilder();
			Scanner reader2 = new Scanner(actualValue.get());
			while (reader2.hasNext()) {
				sb2.append(reader2.next());
			}
			// test que le contenu du fichier ne change pas apres stockage dans le fileStorageManager
			assertEquals("le contenu du fichier après sauvegarde a changé", sb.toString(), sb2.toString());
			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSaveAndGetSPecialPath()
	{
		FileStoreManager fsm = new FileStoreManager();
		
		
		
		
		fsm.setStorageRoot(new File("c:\\fsm"));
		try {
		
			File f = new File(getClass().getResource("testFile.txt").toURI());
			fsm.saveFile("4*reviews:", 4, f);
			Optional<File> actualValue = fsm.getFile("4*reviews:", 4);
			assertTrue("le fichier n'a pas été retrouvé",actualValue.isPresent());
			
			StringBuilder sb = new StringBuilder();
			Scanner reader = new Scanner(f);
			while (reader.hasNext()) {
				sb.append(reader.next());
			}
			
			StringBuilder sb2 = new StringBuilder();
			Scanner reader2 = new Scanner(actualValue.get());
			while (reader2.hasNext()) {
				sb2.append(reader2.next());
			}
			// test que le contenu du fichier ne change pas apres stockage dans le fileStorageManager
			assertEquals("le contenu du fichier après sauvegarde a changé", sb.toString(), sb2.toString());
			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static Test suite()
	{
        return new TestSuite( FileStoreManagerTest.class );
	}
}
