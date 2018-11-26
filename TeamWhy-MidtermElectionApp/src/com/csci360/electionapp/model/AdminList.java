package com.csci360.electionapp.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;

public class AdminList {

    private ArrayList<Admin> adminPersonList;

    //AdminList - Creator (GRASP)
    //This constructor method creates a new Admin List.
    public AdminList() {
        this.adminPersonList = new ArrayList<Admin>();
    }
    
   
    //CheckForAdmin - Information Expert (GRASP)
    //This method checks to see if the admin is a duplicate with another on adminList.
    public boolean checkForAdmin(String name, String id) {
        boolean adminExists = false;
        String hashID = "";
        try{
        	hashID = findPasswordID(name,id);
        }
        catch (NoSuchAlgorithmException e) {
        	 e.printStackTrace();
        	
        }
        catch (IOException e) {
          	 e.printStackTrace();
          	
          }
        //System.out.println(hashID);

        for (Admin admin: adminPersonList) {
            if (admin.getName().equals(name) && admin.getID().equals(hashID)) {
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
        String hashID = "";
        try{
        	hashID = findPasswordID(name,id);
        }
        catch (NoSuchAlgorithmException e) {
        	 e.printStackTrace();
        	
        }
        catch (IOException e) {
       	 e.printStackTrace();
       	
       }
        for (Admin admin: adminPersonList) {
            if (admin.getName().equals(name) && admin.getID().equals(hashID)) {
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
    
    //Hash password
    public String generatePasswordID(String password) throws NoSuchAlgorithmException, FileNotFoundException {
    	byte[] salt = getSalt();
    	
    	boolean willAppend = true;
    	
    	
    	StringBuilder sb = new StringBuilder();
    	for(byte b : salt) {
    		sb.append(String.format("%02X", b));
    	}
    	
    	try(BufferedWriter saltDoc = new BufferedWriter(new FileWriter("out/salt.txt", willAppend))){
    		
    		saltDoc.append(sb);
    		saltDoc.newLine();
    	
    	}
    	
    	
    	catch(IOException ex) {
    	
    	ex.printStackTrace();
		
		}
    	
    	
    	String securePassword = get_SHA_256_SecurePassword(password, salt);
    	
    	return securePassword;
    }
    
    public String findPasswordID(String name, String password) throws NoSuchAlgorithmException, IOException {
    	
    	//System.out.println(name);
    	BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/adminList.txt"));
	    	String line;
	    	int counterA = 1;
	    	int counterB = 1;
	    	while ((line = br.readLine()) != null) {
	    		String[] adminFromList = line.split("[,]");
	    		//System.out.println("AdminList: " + adminFromList[0]);
	    		if(adminFromList[0].toString().equals(name)) {
	    			counterB = counterA;
	    			
	    		}
	    		if(adminFromList[0].toString().equals(name) == false) {
	    			counterA += 1;
	    		}
    		
	    	}
	    	br.close();
	    	//System.out.println("Counter: " + counterB);
	    BufferedReader br2 = new BufferedReader(new FileReader("out/salt.txt"));
		    	String line2 = "";
		    	for(int i = 0; i<counterB; i++) {
		    		
		    		line2 = br2.readLine();
		    		
		    		//System.out.println(line2);
	
		    	}
		    	
		    	byte[] salt = new byte[line2.length() / 2];
	    		for(int j = 0; j < line2.length(); j+=2 ) {
	    			int firstDig = Character.digit(line2.substring(j, j+2).charAt(0),16);
	    			int secondDig = Character.digit(line2.substring(j, j+2).charAt(1),16);
	    			salt[j/2] = (byte) ((firstDig << 4) + secondDig);
	    		}
		    	
		 br2.close();
    	String securePassword = get_SHA_256_SecurePassword(password, salt);
    	
    	return securePassword;
    }
    //get_SHA_256_Secure Password
    //From practice example code done in class, SHAExample.java
    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt){
    	String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
        
    }
    //getSalt()
    //From example practice code done in class, SHAExample.java - used to generate initial salt for Admin hashed password
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
 }

