package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Candidate;

public class CandidateTest {
	
	
	private Candidate canTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		canTester = new Candidate();
	}
	/**
	 * Test method for candidate name
	 */
	@Test
	public void testCandidateName(){
		canTester.setCandidateName("John F. Kennedy");
		assertEquals("John F. Kennedy", canTester.getCandidateName());
	}
	/**
	 * Test method for ID
	 */
	@Test
	public void testID(){
		canTester.setID("cand123");
		assertEquals("cand123", canTester.getID());
	}
	/**
	 * Test method for party
	 */
	@Test
	public void testParty(){
		canTester.setParty("Democratic Party");
		assertEquals("Democratic Party", canTester.getParty());
	}
	/**
	 * Test method for running mate
	 */
	@Test
	public void testRunningMate(){
		canTester.setRunningMateName("Lyndon B. Johnson");
		assertEquals("Lyndon B. Johnson", canTester.getRunningMateName());
	}
}
