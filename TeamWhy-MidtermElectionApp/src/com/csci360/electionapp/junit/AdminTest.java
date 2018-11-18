package com.csci360.electionapp.junit;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Admin;

public class AdminTest {
	
	
	private Admin adTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		adTester = new Admin();
	}
	/**
	 * Test method for admin name
	 */
	@Test
	public void testAdminName(){
		adTester.setName("John Smith");
		assertEquals("John Smith", adTester.getName());
	}
	/**
	 * Test method for ID
	 */
	@Test
	public void testID(){
		adTester.setID("admin123");
		assertEquals("admin123", adTester.getID());
	}
	
}
