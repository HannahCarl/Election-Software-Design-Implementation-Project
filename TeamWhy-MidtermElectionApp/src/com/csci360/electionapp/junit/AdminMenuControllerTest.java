package com.csci360.electionapp.junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.controller.AdminMenuController;

public class AdminMenuControllerTest {
	
	private AdminMenuController adMenuCont;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		adMenuCont = new AdminMenuController();
	}
	/**
	 * Test method for isSubmitClicked
	 */
	@Test
	public void testIsSubmitClicked(){
		assertEquals(false, adMenuCont.isSubmitClicked());
	}
	

	


}
