package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Voter;

public class VoterTest {
	
	private Voter voterTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		voterTester = new Voter();
	}
	
	/**
	 * Test method for voterID
	 */
	@Test
	public void testVoterID(){
		voterTester.setVoterID("123ABC");
		assertEquals("123ABC", voterTester.getVoterID());
	}
	/**
	 * Test method for first name
	 */
	@Test
	public void testFirstname(){
		voterTester.setFirstname("John");
		assertEquals("John", voterTester.getFirstname());
	}
	/**
	 * Test method for last name
	 */
	@Test
	public void testLastname(){
		voterTester.setLastname("Brown");
		assertEquals("Brown", voterTester.getLastname());
	}
	/**
	 * Test method for middle initial
	 */
	@Test
	public void testMiddleInitial(){
		voterTester.setMiddleInitial('L');
		assertEquals('L', voterTester.getMiddleInitial());
	}
	
	/**
	 * Test method for socSecNumber
	 */
	@Test
	public void testSocSecNumber(){
		voterTester.setSocSecNumber("111-111-1111");
		assertEquals("111-111-1111", voterTester.getSocSecNumber());
	}
	/**
	 * Test method for Sex
	 */
	@Test
	public void testSex(){
		voterTester.setSex("Female");
		assertEquals("Female", voterTester.getSex());
	}
	/**
	 * Test method for BirthDate
	 */
	@Test
	public void testBirthDate(){
		Date bDate = new Date();
		voterTester.setBirthDate(bDate);
		assertEquals(bDate, voterTester.getBirthDate());
	}
	
	/**
	 * Test method for HomePhone
	 */
	@Test
	public void testHomePhone(){
		voterTester.setHomePhone("555-666-7777");
		assertEquals("555-666-7777", voterTester.getHomePhone());
	}
	/**
	 * Test method for CellPhone
	 */
	@Test
	public void testCellPhone(){
		voterTester.setCellPhone("522-666-7777");
		assertEquals("522-666-7777", voterTester.getCellPhone());
	}
	
	/**
	 * Test method for HomeAddress
	 */
	@Test
	public void testHomeAddress(){
		voterTester.setHomeAddress("123 Peachtree Street, Atlanta, GA, 23456");
		assertEquals("123 Peachtree Street, Atlanta, GA, 23456", voterTester.getHomeAddress());
	}
	
	/**
	 * Test method for MailingAddress
	 */
	@Test
	public void testMailingAddress(){
		voterTester.setMailingAddress("1245 Peachtree Street, Atlanta, GA, 23456");
		assertEquals("1245 Peachtree Street, Atlanta, GA, 23456", voterTester.getMailingAddress());
	}
	
	/**
	 * Test method for hasVoted
	 */
	@Test
	public void testHasVoted(){
		voterTester.setHasVoted(true);
		assertEquals(true, voterTester.getHasVoted());
	}

}
