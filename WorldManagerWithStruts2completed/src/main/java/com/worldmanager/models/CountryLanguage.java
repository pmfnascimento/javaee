package com.worldmanager.models;

import java.io.Serializable;

public class CountryLanguage implements Serializable
{
	/**
	 * Default SerialID.
	 */
	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String language;
	private boolean isOfficial;
	private double percentage;
	
	//create a default constructor so it's here 
	//even if we add explicit later.
	public CountryLanguage()
	{
		//do nothing.
	}
	//create get/set accessors and mutators
	//countryCode String
	public String getCountryCode()
	{
		return countryCode;
	}
	public void setCountryCode(String value)
	{
		countryCode = value;
	}
	//language
	public String getLanguage()
	{
		return language;
	}
	public void setLanguage(String value)
	{
		language = value;
	}
	//isOfficial boolean
	public boolean getIsOfficial()
	{
		return isOfficial;
	}
	public void setIsOfficial(boolean value)
	{
		isOfficial = value;
	}
	//percentage double
	public double getPercentage()
	{
		return percentage;
	}
	public void setPercentage(double value)
	{
		percentage = value;
	}
	
	/**
	 * The CountryLanguage object.
	 * @return String representing CountryLanguage
	 */
	public String toString()
	{
		return String.format("Country Code: %s\t"
			+ "Language: %s\tIs Official: %b\t"
			+ "Percentage: %.1f\n"
			, getCountryCode()
			, getLanguage()
			, getIsOfficial()
			, getPercentage());
	}
}
