package com.csci360.electionapp.model;

import java.util.ArrayList;

public class RegistrantList {
    private ArrayList<Registrant> registeredPersonList;

    //RegistrantList - Creator (GRASP)
    //This constructor method creates a new Registrant List.
    public RegistrantList() {
        this.registeredPersonList = new ArrayList<Registrant>();
    }
    
    //CheckSocial - Information Expert (GRASP)
    //This method checks to see if the social security number provided is a duplicate with another on registeredPersonList.
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
    //CheckForRegistrant - Information Expert (GRASP)
    //This method checks to see if the registrant is a duplicate with another on registeredPersonList.
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

    //GetRegistrantByLoginInfo - Information Expert (GRASP)
    //This method returns the correct registrant based on login info provided.
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

    //AddRegistrant - Low Coupling (GRASP)
    //This method adds a new registrant to the registeredPersonList.
    public void addRegistrant(Registrant registrant) {
    	registeredPersonList.add(registrant);
    }
 }

