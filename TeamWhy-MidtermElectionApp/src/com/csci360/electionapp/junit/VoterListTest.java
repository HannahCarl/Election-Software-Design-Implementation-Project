package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;

public class VoterListTest {
	
	private VoterList voterListTester;
	private Voter voterTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		voterListTester = new VoterList();
		voterTester = new Voter("vote123", "John", "Smith", 'M',  "123456789", "male", new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress");
		voterListTester.addVoter(voterTester);
	}
	
	/**
	 * Test method for checkSocial
	 */
	@Test
	public void testCheckSocial(){
		
		assertEquals(true, voterListTester.checkSocial("123456789"));
	}
	
	/**
	 * Test method for checkForVoter
	 */
	@Test
	public void testCheckForVoter(){

		assertEquals(true, voterListTester.checkForVoter("vote123", "123456789"));
	}
	
	/**
	 * Test method for getVoterByLoginInfo
	 */
	@Test
	public void testGetVoterByLoginInfo(){
		
		assertEquals(voterTester, voterListTester.getVoterByLoginInfo("vote123", "123456789"));
	}

}
