package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;
import com.csci360.electionapp.model.VotingSession;

public class VotingSessionTest {
	
	private VotingSession voteSessionTester;
	private VoterList voteListTester;
	private Voter voteTester;

	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		voteListTester = new VoterList();
		voteTester = new Voter("vote123", "John", "Smith", 'M',  "123456789", "male", new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress");
		voteListTester.addVoter(voteTester);
		voteSessionTester = new VotingSession("vote123","123456789",voteListTester );
	}
	
	/**
	 * Test method for voterLogin
	 */
	@Test
	public void testvoterLogin(){
		
		assertEquals(true, voteSessionTester.voterLogin("vote123","123456789",voteListTester ));
	}

}

