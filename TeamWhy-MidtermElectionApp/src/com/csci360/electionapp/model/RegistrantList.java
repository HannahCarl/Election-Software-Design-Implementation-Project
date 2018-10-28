package com.csci360.electionapp.model;

import java.util.ArrayList;

public class RegistrantList {
    private ArrayList<Registrant> registeredPersonList;

    public RegistrantList() {
        this.registeredPersonList = new ArrayList<Registrant>();
    }

    public boolean checkSocial(String social) {
        boolean socialIsDupe = false;

        for (Registrant registrant: registeredPersonList) {
            if (registrant.getSocSecNumber().equals(social)) {
                socialIsDupe = true;

                break;
            }
        }
        return socialIsDupe;
    }

    public boolean checkForRegistrant(String firstName, String lastName, String socSecNum) {
        boolean registrantExists = false;

        for (Registrant registrant: registeredPersonList) {
            if (registrant.getFirstname().equals(firstName) && registrant.getLastname().equals(lastName) && registrant.getSocSecNumber().equals(socSecNum)) {
                registrantExists = true;

                break;
            }
        }

        return registrantExists;
    }

    public Registrant getRegistrantByLoginInfo(String firstName, String lastName, String socSecNum) {
        Registrant desiredRegistrant = null;

        for (Registrant registrant: registeredPersonList) {
            if (registrant.getFirstname().equals(firstName) && registrant.getLastname().equals(lastName) && registrant.getSocSecNumber().equals(socSecNum)) {
                desiredRegistrant = registrant;

                break;
            }
        }

        return desiredRegistrant;
    }

    public void addRegistrant(Registrant registrant) {
    	registeredPersonList.add(registrant);
    }
 }

