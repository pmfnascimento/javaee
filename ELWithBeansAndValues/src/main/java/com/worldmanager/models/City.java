package com.worldmanager.models;

import java.io.Serializable;

public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
	
	//public default constructor
	public City()
	{
		//do nothing.
	}
	
	//create our get/set mutators/accessors
	//id
	public int getId()
	{
		return id;
	}
	public void setId(int value)
	{
		id = value;
	}
	//name
	public String getName()
	{
		return name;
	}
	public void setName(String value)
	{
		name = value;
	}
	//countryCode
	public String getCountryCode()
	{
		return countryCode;
	}
	public void setCountryCode(String value)
	{
		countryCode = value;
	}
	//district
	public String getDistrict()
	{
		return district;
	}
	public void setDistrict(String value)
	{
		district = value;
	}
	//population
	public int getPopulation()
	{
		return population;
	}
	public void setPopulation(int value)
	{
		population = value;
	}
	
	//toString
	public String toString()
	{
		return String.format("Id: %d\tName: %s\tCountry Code: %s\t"
								+ "District: %s\tPopulation: %d\n"
							, getId()
							, getName()
							, getCountryCode()
							, getDistrict()
							, getPopulation());
	}
}
