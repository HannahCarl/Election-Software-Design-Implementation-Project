package com.csci360.electionapp.model;

public class RegisteringSession {
    private Registrant registrant;

    public RegisteringSession(String firstName, String lastName, String socSecNum, RegistrantList registrantList) {

    }

    public boolean registrantLogin(String firstName, String lastName, String socSecNum, RegistrantList registrantList) {
        if (registrantList.checkForRegistrant(firstName, lastName, socSecNum) == true) {
            this.registrant = registrantList.getRegistrantByLoginInfo(firstName, lastName, socSecNum);

            return true;
        }


        return false;
    }
}
