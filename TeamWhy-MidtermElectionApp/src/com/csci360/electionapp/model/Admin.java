package com.csci360.electionapp.model;

public class Admin {
    private String name;
    private String id;
    
    //Admin - Creator (GRASP)
    //This method is an empty constructor to build an admin.
    public Admin() {
    	
    }
    
    //Admin - Creator (GRASP)
    //This method is a parameterized constructor to build an admin.
    public Admin(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    //getName - Information Expert (GRASP)
    //This method returns the admin name information.
    public String getName() {
        return name;
    }

    //setName - Low Coupling (GRASP)
    //This method sets the admin name information.
    public void setName(String name) {
        this.name = name;
    }

    //getID - Information Expert (GRASP)
    //This method returns the admin ID information.
    public String getID() {
        return id;
    }

    //setID - Low Coupling (GRASP)
    //This method sets the admin ID information.
    public void setID(String id) {
        this.id = id;
    }
}
