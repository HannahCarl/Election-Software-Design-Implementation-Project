package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Admin;
import com.csci360.electionapp.model.AdminList;
import com.csci360.electionapp.model.AdminSession;

public class AdminSessionTest {
	
	private AdminSession adSessionTester;
	private AdminList adListTester;
	private Admin adTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		adListTester = new AdminList();
		adTester = new Admin("John Smith", "admin123");
		adListTester.addAdmin(adTester);
		adSessionTester = new AdminSession("John Smith", "admin123",adListTester );
	}
	
	/**
	 * Test method for adminLogin
	 */
	@Test
	public void testAdminLogin(){
		
		assertEquals(true, adSessionTester.adminLogin("John Smith", "admin123",adListTester));
	}

}
