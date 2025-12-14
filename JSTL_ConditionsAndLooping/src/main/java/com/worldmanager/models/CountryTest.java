package com.worldmanager.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountryTest {
	Country c;
	private String code = "USA";
	private String name = "United States of America";
	private String continent = "North America";
	private String region = "Middle";
	private double surfaceArea = 123456.7;
	private int indepYear = 1776;
	private int population = 350000000;
	private double lifeExpectancy = 73;
	private double gnp = 15000000000000.0;
	private double gnpOld = 14000000000000.0;
	private String localName = "USA";
	private String governmentForm = "Democracy";
	private String headOfState = "Obama";
	private String capital = "Washington, D. C.";
	private String code2 = "123151515";
	private double delta = 0.00001;
	@Test
	public void testDefaultConstructor() {
		c = new Country();
		assertNotNull("Could not create Country", c);
	}
	
	@Test
	public void testMutatorsAndAccessors()
	{
		c = new Country();
		//code = "USA";
		c.setCode(code);
		assertEquals("Could not set code as expected"
				, code, c.getCode());
		//name = "United States of America";
		c.setName(name);
		assertEquals("Could not set name as expected"
				, name, c.getName());
		//continent = "North America";
		c.setContinent(continent);
		assertEquals("Could not set continent as expected"
				, continent, c.getContinent());
		//region = "Middle";
		c.setRegion(region);
		assertEquals("Could not set region as expected"
				, region, c.getRegion());
		//surfaceArea = 123456.7;
		c.setSurfaceArea(surfaceArea);
		assertEquals("Could not set surfaceArea as expected"
				, surfaceArea, c.getSurfaceArea(), delta);
		//indepYear = 1776;
		c.setIndepYear(indepYear);
		assertEquals("Could not set indep year as expected"
				, indepYear, c.getIndepYear());
		//population = 350000000;
		c.setPopulation(population);
		assertEquals("Could not set population as expected"
				, population, c.getPopulation());
		//lifeExpectancy = 73;
		c.setLifeExpectancy(lifeExpectancy);
		assertEquals("Could not set life as expected"
				, lifeExpectancy, c.getLifeExpectancy(), delta);
		//gnp = 15000000000000.0;
		c.setGnp(gnp);
		assertEquals("Could not set gnp as expected"
				, gnp, c.getGnp(), delta);
		//gnpOld = 14000000000000.0;
		c.setGnpOld(gnpOld);
		assertEquals("Could not set gnp old as expected"
				, gnpOld, c.getGnpOld(), delta);
		//localName = "USA";
		c.setLocalName(localName);
		assertEquals("Could not set local name as expected"
				, localName, c.getLocalName());
		//governmentForm = "Democracy";
		c.setGovernmentForm(governmentForm);
		assertEquals("Could not set government as expected"
				, governmentForm, c.getGovernmentForm());
		//headOfState = "The Current President";
		c.setHeadOfState(headOfState);
		assertEquals("Could not set head of state as expected"
				, headOfState, c.getHeadOfState());
		//capital = "Washington, D. C.";
		c.setCapital(capital);
		assertEquals("Could not set capital as expected"
				, capital, c.getCapital());
		//code2 = "123151515";
		c.setCode2(code2);
		assertEquals("Could not set code2 as expected"
				, code2, c.getCode2());
	}
	
	@Test
	public void testToString()
	{
		c = new Country();
		//code = "USA";
		c.setCode(code);
		//name = "United States of America";
		c.setName(name);
		//continent = "North America";
		c.setContinent(continent);
		//region = "Middle";
		c.setRegion(region);
		//surfaceArea = 123456.7;
		c.setSurfaceArea(surfaceArea);
		//indepYear = 1776;
		c.setIndepYear(indepYear);
		//population = 350000000;
		c.setPopulation(population);
		//lifeExpectancy = 73;
		c.setLifeExpectancy(lifeExpectancy);
		//gnp = 15000000000000.0;
		c.setGnp(gnp);
		//gnpOld = 14000000000000.0;
		c.setGnpOld(gnpOld);
		//localName = "USA";
		c.setLocalName(localName);
		//governmentForm = "Democracy";
		c.setGovernmentForm(governmentForm);
		//headOfState = "The Current President";
		c.setHeadOfState(headOfState);
		//capital = "Washington, D. C.";
		c.setCapital(capital);
		//code2 = "123151515";
		c.setCode2(code2);
		
		
		String retStr = c.toString();
		assertTrue("To String does not contain expected value for Code"
					, retStr.contains(code));	
		assertTrue("To String does not contain expected value for Name"
				, retStr.contains(name));	
		assertTrue("To String does not contain expected value for region"
				, retStr.contains(region));
		assertTrue("To String does not contain expected value for surface area"
				, retStr.contains(String.format("%.1f", surfaceArea)));	
		assertTrue("To String does not contain expected value for indepYear"
				, retStr.contains(String.format("%d", indepYear)));
		assertTrue("To String does not contain expected value for population"
				, retStr.contains(String.format("%d", population)));	
		assertTrue("To String does not contain expected value for lifeExpectancy"
				, retStr.contains(String.format("%.1f", lifeExpectancy)));	
		assertTrue("To String does not contain expected value for gnp"
				, retStr.contains(String.format("%.1f", gnp)));	
		assertTrue("To String does not contain expected value for gnpOld"
				, retStr.contains(String.format("%.1f", gnpOld)));	
		assertTrue("To String does not contain expected value for localName"
				, retStr.contains(localName));	
		assertTrue("To String does not contain expected value for governmentForm"
				, retStr.contains(governmentForm));	
		assertTrue("To String does not contain expected value for headOfState"
				, retStr.contains(headOfState));	
		assertTrue("To String does not contain expected value for capital"
				, retStr.contains(capital));	
		assertTrue("To String does not contain expected value for Code2"
				, retStr.contains(code2));	
		
	}

}
