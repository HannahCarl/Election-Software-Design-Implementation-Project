package com.csci360.electionapp.model;

import java.util.Date;

public class Registrant {
    private String voterID;
    private String firstname;
    private String lastname;
    private char middleInitial;
    private String suffix;
    private String socSecNumber;
    private String sex;
    private String race;
    private Date birthDate;
    private String homePhone;
    private String cellPhone;
    private String homeAddress;
    private String mailingAddress;
    private boolean hasRegistered;
    private boolean usCitizenCheck;
    private boolean ageCheck;
    
    //Registrant - Creator (GRASP)
    //This method is an empty constructor to build a registrant.
    public Registrant() {
    }

    //Registrant - Creator (GRASP)
    //This method is a parameterized constructor to build a registrant.
    public Registrant(String voterID, String firstname, String lastname, char middleInitial, String suffix, String socSecNumber, String sex, String race, Date birthDate, String homePhone, String cellPhone, String homeAddress, String mailingAddress, Boolean ageCheck, Boolean usCitizenCheck) {
        this.voterID = voterID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleInitial = middleInitial;
        this.suffix = suffix;
        this.socSecNumber = socSecNumber;
        this.sex = sex;
        this.race = race;
        this.birthDate = birthDate;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.homeAddress = homeAddress;
        this.mailingAddress = mailingAddress;
        this.hasRegistered = false;
        this.usCitizenCheck = usCitizenCheck;
        this.ageCheck = ageCheck;
        
    }
    //getVoterID - Information Expert (GRASP)
    //This method returns the voterID information.
    public String getVoterID() {
        return voterID;
    }
    
    //setVoterID - Low Coupling (GRASP)
    //This method sets the voterID information.
    public void setVoterID(String voterID) {
        this.voterID = voterID;
    }
    
    //getFirstname - Information Expert (GRASP)
    //This method returns the first name information.
    public String getFirstname() {
        return firstname;
    }
    //setFirstname - Low Coupling (GRASP)
    //This method sets the first name information.
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    //getLastname - Information Expert (GRASP)
    //This method returns the last name information.
    public String getLastname() {
        return lastname;
    }
    //setLastname - Low Coupling (GRASP)
    //This method sets the last name information.
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    //getMiddleInitial - Information Expert (GRASP)
    //This method returns the middle initial information.
    public char getMiddleInitial() {
        return middleInitial;
    }
    //setMiddleInitial - Low Coupling (GRASP)
    //This method sets the middle initial information.
    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }
    //getSuffix - Information Expert (GRASP)
    //This method returns the suffix information.
    public String getSuffix() {
        return suffix;
    }
    //setVoterID - Low Coupling (GRASP)
    //This method sets the suffix information.
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    //getSocSecNumber - Information Expert (GRASP)
    //This method returns the social security number information.
    public String getSocSecNumber() {
        return socSecNumber;
    }
    //setSocSecNumber - Low Coupling (GRASP)
    //This method sets the social security number information.
    public void setSocSecNumber(String socSecNumber) {
        this.socSecNumber = socSecNumber;
    }
    //getSex - Information Expert (GRASP)
    //This method returns the sex information.
    public String getSex() {
        return sex;
    }
    //setSex - Low Coupling (GRASP)
    //This method sets the sex information.
    public void setSex(String sex) {
        this.sex = sex;
    }
    //getRace - Information Expert (GRASP)
    //This method returns the race information.
    public String getRace() {
        return race;
    }
    //setRace - Low Coupling (GRASP)
    //This method sets the race information.
    public void setRace(String race) {
        this.race = race;
    }
    //getBirthDate - Information Expert (GRASP)
    //This method returns the birth date information.
    public Date getBirthDate() {
        return birthDate;
    }
    //setBirthDate - Low Coupling (GRASP)
    //This method sets the birth date information.
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    //getHomePhone - Information Expert (GRASP)
    //This method returns the home phone number information.
    public String getHomePhone() {
        return homePhone;
    }
    //setHomePhone - Low Coupling (GRASP)
    //This method sets the home phone number information.
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    //getCellPhone - Information Expert (GRASP)
    //This method returns the cell phone number information.
    public String getCellPhone() {
        return cellPhone;
    }
    //setCellPhone - Low Coupling (GRASP)
    //This method sets the cell phone number information.
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    //getHomeAddress - Information Expert (GRASP)
    //This method returns the home address information.
    public String getHomeAddress() {
        return homeAddress;
    }
    //setHomeAddress - Low Coupling (GRASP)
    //This method sets the home address information.
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    //getMailingAddress - Information Expert (GRASP)
    //This method returns the mailing address information.
    public String getMailingAddress() {
        return mailingAddress;
    }
    //setMailingAddress - Low Coupling (GRASP)
    //This method sets the mailing address information.
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
    //getHasRegistered - Information Expert (GRASP)
    //This method returns whether a person has registered.
    public boolean getHasRegistered() {
        return hasRegistered;
    }
    //setHasRegistered - Low Coupling (GRASP)
    //This method sets whether a person has registered.
    public void setHasRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }
    //getUSCitizenCheck - Information Expert (GRASP)
    //This method returns whether a person is a US citizen.
    public boolean getUSCitizenCheck() {
    	return usCitizenCheck;
    }
    //setUSCitizenCheck - Low Coupling (GRASP)
    //This method sets whether a person is a US citizen.
    public void setUSCitizenCheck(boolean usCitizenCheck) {
    	this.usCitizenCheck = usCitizenCheck;
    }
    //getAgeCheck - Information Expert (GRASP)
    //This method returns whether a person is 18 years old.
    public boolean getAgeCheck() {
    	return ageCheck;
    }
    //setAgeCheck - Low Coupling (GRASP)
    //This method sets whether a person is 18 years old.
    public void setAgeCheck(boolean ageCheck) {
    	this.ageCheck = ageCheck;
    }
}

