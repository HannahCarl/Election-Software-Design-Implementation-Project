package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Ballot;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.Candidate;

public class BallotTest {
	
	private Voter voterTester;
	private Ballot bTester;
	private Candidate canTester;
	private ArrayList<Candidate> voteListTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		voterTester = new Voter();
		canTester = new Candidate();
		bTester = new Ballot(voterTester);
		voteListTester = new ArrayList<Candidate>();
	}
	/**
	 * Test method for getting the voter casting the ballot
	 */
	@Test
	public void testVote(){
		
		assertEquals(voterTester, bTester.getVoter());
	}
	
	/**
	 * Test method for the get vote list and add vote
	 */
	@Test
	public void testgetVoteList(){
		voteListTester.add(canTester);
		bTester.addVote(canTester);
		assertEquals(voteListTester, bTester.getVoteList());
	}
	/**
	 * Test method for the get vote list and set vote list
	 */
	@Test
	public void testgetVoteList2(){
		voteListTester.add(canTester);
		bTester.setVoteList(voteListTester);
		assertEquals(voteListTester, bTester.getVoteList());
	}
	
}
