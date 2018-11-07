package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import com.csci360.electionapp.model.Admin;
import com.csci360.electionapp.model.Voter;

public class AdminTest {
	
	private Admin adminTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		adminTester = new Admin("bob111","password1");
	}

	/**
	 * Test method for userName
	 */
	@Test
	public void testUsername(){
		adminTester.setUsername("123ABC");
		assertEquals("123ABC", adminTester.getUsername());
	}
	
	/**
	 * Test method for password
	 */
	@Test
	public void testPassword(){
		adminTester.setPassword("123dog");
		assertEquals("123dog", adminTester.getPassword());
	}
}
