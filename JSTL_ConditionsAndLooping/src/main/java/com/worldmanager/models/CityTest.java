package com.worldmanager.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CityTest {
	City c;
	private int id = 10;
	private String name = "Chicago";
	private String countryCode = "USA";
	private String district = "Illinois";
	private int population = 2750000;
	
	@Before
	public void setUp() throws Exception {
		c = new City();
	}

	@Test
	public void testDefaultConstructor() {
		assertNotNull("Could not create default City", c);
	}
	
	@Test
	public void testMutatorsAndAccessors() {
		//int id;
		c.setId(id);
		assertEquals("Could not set ID as expected"
				, id, c.getId());
		//String name;
		c.setName(name);
		assertEquals("Could not get name as expected"
				, name, c.getName());
		//String countryCode;
		c.setCountryCode(countryCode);
		assertEquals("Could not set country code as expected"
				, countryCode, c.getCountryCode());
		//String district;
		c.setDistrict(district);
		
		assertEquals("Could not set district as expected"
				, district, c.getDistrict());
		//int population;
		c.setPopulation(population);
		assertEquals("Could not set population as expected"
				, population, c.getPopulation());
	}
	
	@Test
	public void testToString()
	{
		c.setId(id);
		c.setName(name);
		c.setCountryCode(countryCode);
		c.setDistrict(district);
		c.setPopulation(population);
		
		String retStr = c.toString();
		assertTrue("To String does not contain expected value for id "
				, retStr.contains(String.format("%d", id)));
		assertTrue("To String does not contain expected value for name "
				, retStr.contains(name));
		assertTrue("To String does not contain expected value for countryCode "
				, retStr.contains(countryCode));
		assertTrue("To String does not contain expected value for district "
				, retStr.contains(district));
		assertTrue("To String does not contain expected value for population "
				, retStr.contains(String.format("%d", population)));
	}

}
