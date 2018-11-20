package com.csci360.electionapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Election {
	
	//A list of each of each position/title being contested in the election
	private ArrayList<String> titleList;
	
	//An array containing the list of candidates for each position/title being contested in the election
	private ArrayList<ArrayList<Candidate>> selectionList;
	
	//A list to hold the results
	private ArrayList<Ballot> ballotList;
	
	//date of the election
	private Date date;
	
	public Election() {
		
	}
	
	//Constructor for the election
	//GRASP - Creator
	public Election(Date date) {
		date = this.date;
		titleList = new ArrayList<String>();
		selectionList = new ArrayList<ArrayList<Candidate>>();
		ballotList = new ArrayList<Ballot>();
	}
	
	//Setter for titleList
	//GRASP - Creator
	public void setTitleList(ArrayList<String> titleList) {
		titleList = this.titleList;
	}
	
	//Getter for titleList
	//GRASP - Information Expert
	public ArrayList<String> getTitleList() {
		return titleList;
	}
	
	//Setter for selectionList
	//GRASP - Creator
	public void setCandidateList(ArrayList<ArrayList<Candidate>> selectionList) {
		selectionList = this.selectionList;
	}
	
	//Getter for selectionList
	//GRASP - Information Expert
	public ArrayList<ArrayList<Candidate>> getSelectionList() {
		return selectionList;
	}
	
	//Getter for ballotList
	//GRASP - Information Expert
	public ArrayList<Ballot> getBallotList() {
		return ballotList;
	}
	
	//Adds a field to the section with the title being run for and the list of candidates running for it
	//GRASP - Creator
	public void addField(String title, ArrayList<Candidate> candidateList) {
		titleList.add(title);
		selectionList.add(candidateList);
	}
	
	//A method for casting a ballot, detects if a duplicate vote is attempted
	//Grasp - Creator
	public void castBallot(Ballot ballot) {
		for (Ballot vote : ballotList) { //loops through the list of current votes and makes sure the ballot being cast is not by a voter who has already cast one
			if (ballot.getVoter().equals(vote.getVoter())) {
				return; //escapes from the method if a duplicate vote is attempted
			}
		}
		
		//Date birthday = ballot.getVoter().getBirthDate();
		//Add a check to make sure the voter is of age here
		
		
		ballotList.add(ballot); //adds the ballot to the list
	}
	
	//finds the title/field being run for by its array id/field number
	//GRASP - Information Expert
	public String getTitleByFieldNumber(int fieldNum) {
		return titleList.get(fieldNum); 
	}
	
	//finds the list of candidates running for a field by its array id/field number
	//GRASP - Information Expert
	public ArrayList<Candidate> getCandidateListByFieldNumber(int fieldNum) {
		return selectionList.get(fieldNum);
	}
	
	//finds the list of candidates running for a field/title by the name of the field or title they're running for
	//GRASP - Information Expert
	public ArrayList<Candidate> getCandidateListByFieldTitle(String title) {
		ArrayList<Candidate> returnList = new ArrayList<Candidate>();
		
		int listID = 0; //counter to help find the list of candidates
		for (String list : titleList) { //loops through the list of titles being run for
			if (list.equals(title)) { //if a matching name is found, it will set the returned list to be that list
				returnList = selectionList.get(listID);
			}
			listID++;
		}
		
		return returnList;
	}
	
	//INCOMPLETE
	//A method for ending the election, setting it to null after recording the results to an encrypted file
	//GRASP - Creator
	public void endElection() {
		
	}
}
