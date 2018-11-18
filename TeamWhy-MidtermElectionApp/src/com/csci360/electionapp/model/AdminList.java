package com.csci360.electionapp.model;

import java.util.ArrayList;

public class AdminList {

    private ArrayList<Admin> adminPersonList;

    //AdminList - Creator (GRASP)
    //This constructor method creates a new Admin List.
    public AdminList() {
        this.adminPersonList = new ArrayList<Admin>();
    }
    
   
    //CheckForAdmin - Information Expert (GRASP)
    //This method checks to see if the registrant is a duplicate with another on registeredPersonList.
    public boolean checkForAdmin(String name, String id) {
        boolean adminExists = false;

        for (Admin admin: adminPersonList) {
            if (admin.getName().equals(name) && admin.getID().equals(id)) {
                adminExists = true;

                break;
            }
        }

        return adminExists;
    }

    //GetAdminByLoginInfo - Information Expert (GRASP)
    //This method returns the correct admin based on login info provided.
    public Admin getAdminByLoginInfo(String name, String id) {
        Admin desiredAdmin = null;

        for (Admin admin: adminPersonList) {
            if (admin.getName().equals(name) && admin.getID().equals(id)) {
                desiredAdmin = admin;

                break;
            }
        }

        return desiredAdmin;
    }

    //AddAdmin - Low Coupling (GRASP)
    //This method adds a new admin to the adminPersonList.
    public void addAdmin(Admin admin) {
    	adminPersonList.add(admin);
    }
 }
