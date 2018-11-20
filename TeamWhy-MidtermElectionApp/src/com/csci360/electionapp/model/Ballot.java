package com.csci360.electionapp.model;

import java.util.ArrayList;

public class Ballot {
	private Voter voter; //Voter casting the ballot
	private ArrayList<Candidate> voteList; //list of choices of candidates

	//Constructor
	//GRASP - Creator
	public Ballot(Voter voter) {
		voter = this.voter;
		voteList = new ArrayList<Candidate>();
	}
	
	//adds a vote selection to the list for the ballot
	//GRASP - Creator
	public void addVote(Candidate candidate) {
		voteList.add(candidate);
	}
	
	//edits one of the candidate choices based on the choice number
	//GRASP - Creator
	public void editVote(int id, Candidate candidate) {
		if (id > (voteList.size() - 1)) {
			return; //an escape condition to make sure an array out of bound exception doesn't occur
		}
		
		voteList.set(id, candidate);
	}
	
	//Gets the list of choices
	//GRASP - Information Expert
	public ArrayList<Candidate> getVoteList(){
		return voteList;
	}
	
	//Sets the list of votes, in case of full edit
	//GRASP - Creator
	public void setVoteList(ArrayList<Candidate> voteList) {
		voteList = this.voteList;
	}
	
	//Gets the voter casting the ballot
	//GRASP - Information Expert
	public Voter getVoter() {
		return voter;
	}
	
	
}
