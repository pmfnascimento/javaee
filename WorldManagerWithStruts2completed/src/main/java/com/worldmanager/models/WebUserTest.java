package com.worldmanager.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WebUserTest {
	WebUser wu;
	String uid = "authorized user";
	String pwd = "12@31x#C124";
	int authLevel = 19;
	int id = 99;
	
	@Before
	public void setUp() throws Exception {
		wu = new WebUser();
		wu.setUserId(uid);
		wu.setPassword(pwd);
		wu.setAuthLevel(authLevel);
		wu.setId(id);
	}

	@Test
	public void testConstructor() {
		assertNotNull("Default constructor not working for WebUser");
	}
	
	@Test
	public void testMutatorsAndAccessors()
	{
		assertEquals("Value not set correctly for uid"
				, uid, wu.getUserId());
		assertEquals("Value not set correctly for pwd"
				, pwd, wu.getPassword());
		assertEquals("Value not set correctly for auth Level"
				, authLevel
				, wu.getAuthLevel());
	    assertEquals("Value not set correctly for id"
	    		, id, wu.getId());
	}
	
	@Test
	public void testToString()
	{
		String retStr = wu.toString();
		assertTrue("To String does not contain uid"
				, retStr.contains(uid));
		assertTrue("To String does not contain pwd"
				, retStr.contains(pwd));
		assertTrue("To String does not contain authLevel"
				, retStr.contains(String.format("%d", authLevel)));
		assertTrue("To String does not contain id"
					, retStr.contains(String.format("%d", id)));
	}

}
