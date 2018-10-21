package com.csci360.electionapp.model;

public class VotingSession {
    private Voter voter;

    public VotingSession(String text, String socSecFieldText, VoterList voterList) {

    }

    public boolean voterLogin(String voterID, String socSecNum, VoterList voterList) {
        if (voterList.checkForVoter(voterID, socSecNum) == true) {
            this.voter = voterList.getVoterByLoginInfo(voterID, socSecNum);

            return true;
        }


        return false;
    }
}
