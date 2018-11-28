package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.AESEncryption;
import com.csci360.electionapp.model.ResultsDisplay;
import com.csci360.electionapp.model.Voter;

public class ResultsDisplayTest {
	
	private ResultsDisplay rdTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		rdTester = new ResultsDisplay("","");
	}
	
	/**
	 * Test method for candidate name
	 */
	@Test
	public void testCandName(){
		
		rdTester.setCandName("John Adams");
		assertEquals("John Adams", rdTester.getCandName());
	}
	
	/**
	 * Test method for candidate votes
	 */
	@Test
	public void testCandVotes(){
		
		rdTester.setCandVotes("130");
		assertEquals("130", rdTester.getCandVotes());
	}

}
