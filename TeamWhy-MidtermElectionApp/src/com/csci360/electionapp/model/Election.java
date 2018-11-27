package com.csci360.electionapp.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Election {
	
	//A list of each of each position/title being contested in the election
	private ArrayList<String> titleList;
	
	//An array containing the list of candidates for each position/title being contested in the election
	private ArrayList<ArrayList<Candidate>> selectionList;
	
	//A list to hold the results
	private ArrayList<Ballot> ballotList;
	
	
	//Constructor for the election
	//GRASP - Creator
	public Election() {
		this.titleList = new ArrayList<String>();
		this.selectionList = new ArrayList<ArrayList<Candidate>>();
		this.ballotList = new ArrayList<Ballot>();
	}
	
	//Setter for titleList
	//GRASP - Creator
	public void setTitleList(ArrayList<String> titleList) {
		this.titleList = titleList;
	}
	
	//Getter for titleList
	//GRASP - Information Expert
	public ArrayList<String> getTitleList() {
		return titleList;
	}
	
	//Setter for selectionList
	//GRASP - Creator
	public void setCandidateList(ArrayList<ArrayList<Candidate>> selectionList) {
		this.selectionList = selectionList;
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
	
	//A method for recording the election, adding the tallied results to a cvs file
	//GRASP - Creator
	public void exportResults() {
		
		int totalVotes = 0;
		
		//initializes the list of presidential candidates that received votes, and initializes their tally to 0 
		ArrayList<Candidate> presidentCandidates = selectionList.get(0);
		ArrayList<Integer> presidentTally = new ArrayList<Integer>();
		
		for (int i = 0; i < presidentCandidates.size(); i++) {
			presidentTally.add(0);
		}
		
		//initializes the list of senate candidates that received votes, and initializes their tally to 0 
		ArrayList<Candidate> senateCandidates = selectionList.get(1);
		ArrayList<Integer> senateTally = new ArrayList<Integer>();
				
		for (int i = 0; i < senateCandidates.size(); i++) {
			senateTally.add(0);
		}
		
		//initializes the list of house candidates that received votes, and initializes their tally to 0 
		ArrayList<Candidate> houseCandidates = selectionList.get(2);
		ArrayList<Integer> houseTally = new ArrayList<Integer>();
						
		for (int i = 0; i < houseCandidates.size(); i++) {
			houseTally.add(0);
		}
		
		for (Ballot vote : ballotList) {
			ArrayList<Candidate> voteList = vote.getVoteList();
			
			//adds the vote to the presidential tally
			Candidate presVote = voteList.get(0);
			
			boolean presCanExists = false; // used to check if the candidate is in the list already, useful for write in functionality
			int presCounter = 0; //counter to make sure the candidates list lines up with their tallies
			for (Candidate candidate: presidentCandidates) {
				if (candidate.getCandidateName().equals(presVote.getCandidateName())) { //this checks if the candidate is on the list already
					presCanExists = true;
					presidentTally.set(presCounter, presidentTally.get(presCounter) + 1); //adds one to the vote number for the candidate
				}
				presCounter++;
			}
			
			if (presCanExists == false) { //if they didnt exist this will add them to the list and add the vote they just received
				presidentCandidates.add(presVote);
				presidentTally.add(1);
			}
			
			//adds the vote to the senate tally
			Candidate senVote = voteList.get(1);
			
			boolean senCanExists = false; // used to check if the candidate is in the list already, useful for write in functionality
			int senCounter = 0; //counter to make sure the candidates list lines up with their tallies
			for (Candidate candidate: senateCandidates) {
				if (candidate.getCandidateName().equals(senVote.getCandidateName())) { //this checks if the candidate is on the list already
					senCanExists = true;
					senateTally.set(senCounter, senateTally.get(senCounter) + 1); //adds one to the vote number for the candidate
				}
				presCounter++;
			}
			
			if (senCanExists == false) { //if they didnt exist this will add them to the list and add the vote they just received
				senateCandidates.add(presVote);
				senateTally.add(1);
			}
			
			//adds the vote to the house tally
			Candidate houseVote = voteList.get(2);
			
			boolean houseCanExists = false; // used to check if the candidate is in the list already, useful for write in functionality
			int houseCounter = 0; //counter to make sure the candidates list lines up with their tallies
			for (Candidate candidate: houseCandidates) {
				if (candidate.getCandidateName().equals(houseVote.getCandidateName())) { //this checks if the candidate is on the list already
					houseCanExists = true;
					houseTally.set(houseCounter, houseTally.get(presCounter) + 1); //adds one to the vote number for the candidate
				}
				houseCounter++;
			}
			
			if (houseCanExists == false) { //if they didnt exist this will add them to the list and add the vote they just received
				houseCandidates.add(presVote);
				houseTally.add(1);
			}
			
			//adds to the total votes
			totalVotes++;
			
			try{
				File presFile = new File("src/com/csci360/electionapp/input/presidentResults.txt");
				File senFile = new File("src/com/csci360/electionapp/input/senateResults.txt");
				File houseFile = new File("src/com/csci360/electionapp/input/houseResults.txt");
				File totalFile = new File("src/com/csci360/electionapp/input/totalVoteCounts.txt");
			
				presFile.delete();
				senFile.delete();
				houseFile.delete();
				
				totalFile.delete();
				
				//outputs the president results into a results file
				BufferedWriter presWriter = new BufferedWriter(new FileWriter(presFile));
				
				for (int i = 0; i < presidentCandidates.size(); i++) {
					presWriter.append(presidentCandidates.get(i) + ", " + presidentTally.get(i));
					presWriter.newLine();
				}
				presWriter.close();
				
				//outputs the senate results to a results file
				BufferedWriter senWriter = new BufferedWriter(new FileWriter(senFile));
				
				for (int i = 0; i < senateCandidates.size(); i++) {
					senWriter.append(senateCandidates.get(i) + ", " + senateTally.get(i));
					senWriter.newLine();
				}
				senWriter.close();
				
				//outputs the house results into a results file
				BufferedWriter houseWriter = new BufferedWriter(new FileWriter(houseFile));
				
				for (int i = 0; i < houseCandidates.size(); i++) {
					houseWriter.append(houseCandidates.get(i) + ", " + houseTally.get(i));
					houseWriter.newLine();
				}
				houseWriter.close();
				
				//outputs the final result
				BufferedWriter totalWriter = new BufferedWriter(new FileWriter(totalFile));
				totalWriter.append("1, " + totalVotes);
				
				totalWriter.close();
				
				//be sure to either reinitialize election or what have after calling this to record results
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			
			
		}
	}
}
