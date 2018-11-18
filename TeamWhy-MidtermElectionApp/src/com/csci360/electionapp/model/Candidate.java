package com.csci360.electionapp.model;

public class Candidate {
	
	private String candidateName;
	private String id;
	private String party;
	private String runningMateName;
	
	//Candidate - Creator (GRASP)
    //This method is an empty constructor to build a candidate.
	public Candidate() {
	}
	
	//Candidate - Creator (GRASP)
    //This method is a constructor to build a candidate with a running mate.
	public Candidate(String candidateName, String id, String party, String runningMateName) {
		this.candidateName = candidateName;
        this.id = id;
        this.party = party;
        this.runningMateName = runningMateName;
	}
	
	//Candidate - Creator (GRASP)
    //This method is a constructor to build a candidate without a running mate.
	public Candidate(String candidateName, String id, String party) {
		this.candidateName = candidateName;
        this.id = id;
        this.party = party;
	}
	
	//getCandidateName - Information Expert (GRASP)
    //This method returns the candidate name.
	public String getCandidateName() {
        return candidateName;
    }
	
	//setCandidateName - Low Coupling (GRASP)
    //This method sets the candidate's name.
	public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
	
	//getID - Information Expert (GRASP)
    //This method returns the candidate's ID information.
	public String getID() {
        return id;
    }
	
	//setID - Low Coupling (GRASP)
    //This method sets the candidate's ID.
	public void setID(String id) {
        this.id = id;
    }
	
	//getParty - Information Expert (GRASP)
    //This method returns the candidate's party.
	public String getParty() {
        return party;
    }
	
	//setParty - Low Coupling (GRASP)
    //This method sets the candidate's party.
	public void setParty(String party) {
        this.party = party;
    }
	
	//getRunningMateName - Information Expert (GRASP)
    //This method returns the candidate's running mate.
	public String getRunningMateName() {
        return runningMateName;
    }
	
	//setRunningMateName - Low Coupling (GRASP)
    //This method sets the candidate's running mate.
	public void setRunningMateName(String runningMateName) {
        this.runningMateName = runningMateName;
    }

}
