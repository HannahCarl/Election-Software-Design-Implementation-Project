package com.csci360.electionapp.model;

public class RegisteringSession {
    private Registrant registrant;

    public RegisteringSession(String firstName, String lastName, String socSecNum, RegistrantList registerantList) {

    }

    public boolean registrantLogin(String firstName, String lastName, String socSecNum, RegistrantList registerantList) {
        if (registerantList.checkForRegistrant(firstName, lastName, socSecNum) == true) {
            this.registrant = registerantList.getRegistrantByLoginInfo(firstName, lastName, socSecNum);

            return true;
        }


        return false;
    }
}
