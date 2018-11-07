package com.csci360.electionapp.junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.controller.RegistrationFormController;

public class RegistrationFormControllerTest {
	
	private RegistrationFormController regFormCont;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		regFormCont = new RegistrationFormController();
	}
	
	/**
	 * Test method for isSubmitClicked
	 */
	@Test
	public void testIsSubmitClicked(){
		assertEquals(false, regFormCont.isSubmitClicked());
	}
	
	/**
	 * Test method for isInputValid
	 */
	@Test
	public void testIsInputValid(){
		assertEquals(true, regFormCont.isInputValid());
	}
	
	

}
