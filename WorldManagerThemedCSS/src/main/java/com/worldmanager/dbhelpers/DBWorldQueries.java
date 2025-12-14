package com.worldmanager.dbhelpers;

import com.worldmanager.models.City;

public class DBWorldQueries 
{
	/**
	 * Get the query for getting US cities.
	 * @return String valid query to select US Cities
	 */
	public static String getCitiesByDistrictByPopulation()
	{
		return "select * from city " 
				+ "where CountryCode = 'USA' " +
				"order by District ASC, Population DESC";
	}
	
	/**
	 * Get the query for inserting a city.
	 * @param c the city to insert
	 * @return String valid query to insert the city
	 */
	public static String insertCity(City c)
	{
		/*
		 * INSERT INTO city
			(Name, CountryCode, District, Population)
			VALUES
			('Z_CITY', 'USA', 'Z_STATE', 234234)
		 */
		return String.format("INSERT INTO city "
				+ "(Name, CountryCode, District, Population) "
				+ "VALUES ('%s', '%s', '%s', '%d')"
					, c.getName()
					, c.getCountryCode()
					, c.getDistrict()
					, c.getPopulation());
	}
	
	/**
	 * Get the query for getting a City by all but ID.
	 * @param c the city to match
	 * @return String query to get the full city object including ID
	 */
	public static String getCityByAllButID(City c)
	{
		/*
		 * select * from city
			where name='Z_CITY' and CountryCode = 'USA' 
			and district = 'Z_STATE' and Population = 234234
		 */
		return String.format("SELECT * FROM CITY WHERE "
				+ "Name = '%s' AND CountryCode = '%s' AND "
				+ "District = '%s' AND Population = %d"
				, c.getName()
				, c.getCountryCode()
				, c.getDistrict()
				, c.getPopulation());
	}
	
	/**
	 * Get the query to get all countries.
	 * @return String query to get the country data
	 */
	public static String getCountriesByName()
	{
		return "select * "
				+ "from country " 
			    + "order by Name";
	}
	
	/**
	 * Get the Country Codes.
	 * @return String query to get the Country Codes
	 */
	public static String getCountryCodes()
	{
		return "SELECT DISTINCT Code "
				+ "FROM country " 
				+ "ORDER BY Code";
	}
	
	/**
	 * Get the Web User by Username And Password.
	 * @param userName the username to match
	 * @param password the password to match
	 * @return String query to find any match to params.
	 */
	public static String getWebUserByUsernameAndPassword(String userName, String password)
	{
		return String.format("SELECT * FROM userinfo "
						+ "where UserName = '%s' "
						+ "and Password = '%s' "
						, userName, password);
	}
	
	
	
	
}
