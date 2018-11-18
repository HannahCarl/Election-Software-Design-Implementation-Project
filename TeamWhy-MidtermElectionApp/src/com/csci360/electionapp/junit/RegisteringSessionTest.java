package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;
import com.csci360.electionapp.model.RegisteringSession;

public class RegisteringSessionTest {
	
	private RegisteringSession regSessionTester;
	private RegistrantList regListTester;
	private Registrant regTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		regListTester = new RegistrantList();
		regTester = new Registrant("vote123", "John", "Smith", "M", "Jr", "1234567890", "male", "Hispanic",new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress", true, true);
		regListTester.addRegistrant(regTester);
		regSessionTester = new RegisteringSession("John", "Smith", "1234567890",regListTester );
	}
	
	/**
	 * Test method for registrantLogin
	 */
	@Test
	public void testRegistrantLogin(){
		
		assertEquals(true, regSessionTester.registrantLogin("John", "Smith", "1234567890",regListTester));
	}

}
