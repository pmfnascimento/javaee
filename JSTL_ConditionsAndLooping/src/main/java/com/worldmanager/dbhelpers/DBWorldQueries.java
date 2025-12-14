package com.worldmanager.dbhelpers;

public class DBWorldQueries {
	public static String getCitiesByDistrictByPopulation()
	{
		return "select * from city " 
				+ "where CountryCode = 'USA' " +
				"order by District ASC, Population DESC";
	}
	
	public static String getCountriesByName()
	{
		return "select * "
				+ "from country " 
			    + "order by Name";
	}
}
