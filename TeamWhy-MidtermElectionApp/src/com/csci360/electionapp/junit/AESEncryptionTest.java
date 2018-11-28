package com.csci360.electionapp.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.csci360.electionapp.model.AESEncryption;
import com.csci360.electionapp.model.Voter;

public class AESEncryptionTest {
	
	private AESEncryption aesTester;
	
	/**
	 * This '@Before' method is ran before every '@Test' method
	 */
	@Before
	public void setup() throws Exception {
		aesTester = new AESEncryption();
	}
	
	/**
	 * Test method for encryption and decryption
	 */
	@Test
	public void testEncryption(){
		
		String encryptedString =  aesTester.encrypt("dog", "123ABC");
		assertEquals("dog", aesTester.decrypt(encryptedString, "123ABC"));
	}
	

}
