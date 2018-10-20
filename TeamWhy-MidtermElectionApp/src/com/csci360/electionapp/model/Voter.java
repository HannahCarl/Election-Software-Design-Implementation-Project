package com.csci360.electionapp.model;

import java.util.Date;

public class Voter {
    private String voterID;
    private String firstname;
    private String lastname;
    private char middleInitial;
    private String socSecNumber;
    private String sex;
    private Date birthDate;
    private String homePhone;
    private String cellPhone;
    private String homeAddress;
    private String mailingAddress;
    private boolean hasVoted;

    public Voter() {
    }

    public Voter(String voterID, String firstname, String lastname, char middleInitial, String socSecNumber, String sex, Date birthDate, String homePhone, String cellPhone, String homeAddress, String mailingAddress) {
        this.voterID = voterID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleInitial = middleInitial;
        this.socSecNumber = socSecNumber;
        this.sex = sex;
        this.birthDate = birthDate;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.homeAddress = homeAddress;
        this.mailingAddress = mailingAddress;
        this.hasVoted = false;
    }

    public String getVoterID() {
        return voterID;
    }

    public void setVoterID(String voterID) {
        this.voterID = voterID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSocSecNumber() {
        return socSecNumber;
    }

    public void setSocSecNumber(String socSecNumber) {
        this.socSecNumber = socSecNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
