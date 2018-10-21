package com.csci360.electionapp.model;

import java.util.ArrayList;

public class VoterList {
    private ArrayList<Voter> registeredVoterList;

    public VoterList() {
        this.registeredVoterList = new ArrayList<Voter>();
    }

    public boolean checkSocial(String social) {
        boolean socialIsDupe = false;

        for (Voter voter: registeredVoterList) {
            if (voter.getSocSecNumber().equals(social)) {
                socialIsDupe = true;

                break;
            }
        }
        return socialIsDupe;
    }

    public boolean checkForVoter(String voterID, String socSecNum) {
        boolean voterExists = false;

        for (Voter voter: registeredVoterList) {
            if (voter.getVoterID().equals(voterID) && voter.getSocSecNumber().equals(socSecNum)) {
                voterExists = true;

                break;
            }
        }

        return voterExists;
    }

    public Voter getVoterByLoginInfo(String voterID, String socSecNum) {
        Voter desiredVoter = null;

        for (Voter voter: registeredVoterList) {
            if (voter.getSocSecNumber().equals(socSecNum) && voter.getVoterID().equals(voterID)) {
                desiredVoter = voter;

                break;
            }
        }

        return desiredVoter;
    }

    public void addVoter(Voter voter) {
        registeredVoterList.add(voter);
    }
 }
