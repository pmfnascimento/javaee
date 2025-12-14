package com.worldmanager.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NavigationDetailsTest {
	NavigationDetails nd;
	String link = "http://www.mysite.com";
	String text = "My Site";
	
	@Before
	public void setUp() throws Exception {
		nd = new NavigationDetails();
		nd.setLink(link);
		nd.setText(text);
	}

	@Test
	public void testConstructor() {
		assertNotNull("Default constructor not working for Navigation Details");
	}
	
	@Test
	public void testMutatorsAndAccessors()
	{
		assertEquals("Value not set correctly for link"
				, link, nd.getLink());
		assertEquals("Value not set correctly for text"
				, text, nd.getText());
	}
	
	@Test
	public void testToString()
	{
		String retStr = nd.toString();
		assertTrue("To String does not contain link"
				, retStr.contains(link));
		assertTrue("To String does not contain text"
				, retStr.contains(text));
	}

}
