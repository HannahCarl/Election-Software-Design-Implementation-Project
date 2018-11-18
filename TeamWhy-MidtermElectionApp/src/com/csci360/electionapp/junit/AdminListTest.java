package com.csci360.electionapp.junit;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Admin;
import com.csci360.electionapp.model.AdminList;

public class AdminListTest {
	
	private AdminList adListTester;
	private Admin adTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		adListTester = new AdminList();
		adTester = new Admin("John Smith", "admin1234");
		adListTester.addAdmin(adTester);
	}
	
	
	/**
	 * Test method for checkForAdmin
	 */
	@Test
	public void testCheckForRegistrant(){

		assertEquals(false, adListTester.checkForAdmin("John", "123-456-7890"));
	}
	
	/**
	 * Test method for getAdminByLoginInfo
	 */
	@Test
	public void testGetAdminByLoginInfo(){
		
		assertEquals(adTester, adListTester.getAdminByLoginInfo("John Smith", "admin1234"));
	}
	

}
