package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import com.csci360.electionapp.model.Registrant;

public class RegistrantTest {
	
	
	private Registrant regTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		regTester = new Registrant();
	}
	
	/**
	 * Test method for voterID
	 */
	@Test
	public void testVoterID(){
		regTester.setVoterID("123ABC");
		assertEquals("123ABC", regTester.getVoterID());
	}
	
	/**
	 * Test method for first name
	 */
	@Test
	public void testFirstname(){
		regTester.setFirstname("John");
		assertEquals("John", regTester.getFirstname());
	}
	
	/**
	 * Test method for last name
	 */
	@Test
	public void testLastname(){
		regTester.setLastname("Brown");
		assertEquals("Brown", regTester.getLastname());
	}

	/**
	 * Test method for middle initial
	 */
	@Test
	public void testMiddleInitial(){
		regTester.setMiddleInitial('L');
		assertEquals('L', regTester.getMiddleInitial());
	}
	
	/**
	 * Test method for suffix
	 */
	@Test
	public void testSuffix(){
		regTester.setSuffix("Jr");
		assertEquals("Jr", regTester.getSuffix());
	}
	
	/**
	 * Test method for socSecNumber
	 */
	@Test
	public void testSocSecNumber(){
		regTester.setSocSecNumber("111-111-1111");
		assertEquals("111-111-1111", regTester.getSocSecNumber());
	}
	/**
	 * Test method for Sex
	 */
	@Test
	public void testSex(){
		regTester.setSex("Female");
		assertEquals("Female", regTester.getSex());
	}
	
	/**
	 * Test method for Race
	 */
	@Test
	public void testRace(){
		regTester.setRace("Hispanic");
		assertEquals("Hispanic", regTester.getRace());
	}
	
	/**
	 * Test method for BirthDate
	 */
	@Test
	public void testBirthDate(){
		Date bDate = new Date();
		regTester.setBirthDate(bDate);
		assertEquals(bDate, regTester.getBirthDate());
	}
	
	/**
	 * Test method for HomePhone
	 */
	@Test
	public void testHomePhone(){
		regTester.setHomePhone("555-666-7777");
		assertEquals("555-666-7777", regTester.getHomePhone());
	}
	/**
	 * Test method for CellPhone
	 */
	@Test
	public void testCellPhone(){
		regTester.setCellPhone("522-666-7777");
		assertEquals("522-666-7777", regTester.getCellPhone());
	}
	
	/**
	 * Test method for HomeAddress
	 */
	@Test
	public void testHomeAddress(){
		regTester.setHomeAddress("123 Peachtree Street, Atlanta, GA, 23456");
		assertEquals("123 Peachtree Street, Atlanta, GA, 23456", regTester.getHomeAddress());
	}
	
	/**
	 * Test method for MailingAddress
	 */
	@Test
	public void testMailingAddress(){
		regTester.setMailingAddress("1245 Peachtree Street, Atlanta, GA, 23456");
		assertEquals("1245 Peachtree Street, Atlanta, GA, 23456", regTester.getMailingAddress());
	}
	
	/**
	 * Test method for hasRegistered
	 */
	@Test
	public void testHasRegistered(){
		regTester.setHasRegistered(true);
		assertEquals(true, regTester.getHasRegistered());
	}
	/**
	 * Test method for USCitizenCheck
	 */
	@Test
	public void testUSCitizenCheck(){
		regTester.setUSCitizenCheck(true);
		assertEquals(true, regTester.getUSCitizenCheck());
	}
	/**
	 * Test method for AgeCheck
	 */
	@Test
	public void testAgeCheck(){
		regTester.setAgeCheck(false);
		assertEquals(false, regTester.getAgeCheck());
	}
}
