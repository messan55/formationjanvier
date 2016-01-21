package com.loncoto.myFirstTDD.util;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AnnotatedFSMTest {


	@BeforeClass
	public static void beforeAlltestExecution() {
		System.out.println("initialisation avant suite de test");
	}
	
	@AfterClass
	public static void afterAlltestExecution() {
		System.out.println("initialisation apres suite test");
	}
	
	
	@Before
	public void beforetestexecution(){
		System.out.println("initialisation avant test");
	}
	
	@After
	public void aftertestexecution(){
		System.out.println("nettoyage après test");
	}
	
	public void fail() {
		System.out.println("methode local fail");
	}
	
	
	@Test
	public void shouldSucced() {
		System.out.println("test shoulSucced");
		assertTrue("this should succed", true);
	}
	
	@Test
	public void shouldSuccedTheRevenge() {
		System.out.println("test shoulSuccedTheRevenge");
		assertTrue("this should succed again", true);
		//fail();
	}
	
	@Test(expected=ArithmeticException.class)
	public void shouldGenerateException() {
		System.out.println("test generate exception");
		if (true) {
			throw new ArithmeticException("problem de calcul");
		}
		System.out.println("test generate exception fin");
	}
	
	
	
	
	
	
}
