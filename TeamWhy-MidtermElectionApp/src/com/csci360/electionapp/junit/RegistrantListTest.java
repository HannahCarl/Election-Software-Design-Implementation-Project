package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;

public class RegistrantListTest {
	
	private RegistrantList regListTester;
	private Registrant regTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		regListTester = new RegistrantList();
		regTester = new Registrant("vote123", "John", "Smith", 'M', "Jr", "1234567890", "male", "Hispanic",new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress", true, true);
		regListTester.addRegistrant(regTester);
	}
	
	/**
	 * Test method for checkSocial
	 */
	@Test
	public void testCheckSocial(){
		
		assertEquals(true, regListTester.checkSocial("1234567890"));
	}
	
	/**
	 * Test method for checkForRegistrant
	 */
	@Test
	public void testCheckForRegistrant(){

		assertEquals(false, regListTester.checkForRegistrant("John", "Smith", "123-456-7890"));
	}
	
	/**
	 * Test method for getRegistrantByLoginInfo
	 */
	@Test
	public void testGetRegistrantByLoginInfo(){
		
		assertEquals(regTester, regListTester.getRegistrantByLoginInfo("John", "Smith", "1234567890"));
	}
	

}
