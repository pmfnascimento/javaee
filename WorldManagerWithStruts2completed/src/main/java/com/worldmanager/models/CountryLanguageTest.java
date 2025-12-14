package com.worldmanager.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountryLanguageTest {
	CountryLanguage cl;
	private String countryCode = "USA";
	private String language = "ENGLISH";
	private boolean isOfficial = true;
	private double percentage = 87.9;
	private double delta = 0.00001;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cl = new CountryLanguage();
	}

	@Test
	public void testDefaultConstructor() {
		assertNotNull("Could not create a new CountryLanguage"
				, cl);
	}
	
	@Test
	public void testMutatorsAndAccessors(){
		cl.setCountryCode(countryCode);
		assertEquals("Could not set country code as expected"
				, countryCode, cl.getCountryCode());
		cl.setIsOfficial(isOfficial);
		assertEquals("Could not set isOfficial as expected"
				, isOfficial, cl.getIsOfficial());
		cl.setPercentage(percentage);
		assertEquals("Could not set percentage as expected"
				, percentage, cl.getPercentage(), delta);
		cl.setLanguage(language);
		assertEquals("Could not set language as expected"
				, language, cl.getLanguage());
	}

	@Test
	public void testToString()
	{
		cl.setCountryCode(countryCode);
		cl.setIsOfficial(isOfficial);
		cl.setPercentage(percentage);
		cl.setLanguage(language);

		String retStr = cl.toString();
		assertTrue("To String does not contain expected value for countryCode "
				, retStr.contains(countryCode));
		assertTrue("To String does not contain expected value for isOfficial "
				, retStr.contains(String.format("%b", isOfficial)));
		assertTrue("To String does not contain expected value for percentage "
				, retStr.contains(String.format("%.1f", percentage)));
		assertTrue("To String does not contain expected value for language "
				, retStr.contains(language));
	}
}
