package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.AESEncryption;
import com.csci360.electionapp.model.MachineDisplay;
import com.csci360.electionapp.model.Voter;

public class MachineDisplayTest {
	
	private MachineDisplay mdTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		mdTester = new MachineDisplay("","");
	}
	
	/**
	 * Test method for machine num
	 */
	@Test
	public void testMachineNumber(){
		
		mdTester.setMachineNum("Machine 1");
		assertEquals("Machine 1", mdTester.getMachineNum());
	}
	/**
	 * Test method for machine votes
	 */
	@Test
	public void testMachineVotes(){
		
		mdTester.setMachineNum("125");
		assertEquals("125", mdTester.getMachineNum());
	}

}
