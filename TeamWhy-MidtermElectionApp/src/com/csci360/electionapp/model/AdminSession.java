package com.csci360.electionapp.model;

public class AdminSession {
	private Admin admin;
	
	public AdminSession(String name, String id, AdminList adminList) {
		
	}
	//Admin Login - Information Expert (GRASP)
    //This method checks the Admin List for Admin and returns boolean
    public boolean adminLogin(String name, String id, AdminList adminList) {
        if (adminList.checkForAdmin(name, id) == true) {
            this.admin = adminList.getAdminByLoginInfo(name, id);

            return true;
        }


        return false;
    }

}
