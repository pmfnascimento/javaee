package com.worldmanager.modelmanagers;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.worldmanager.dbhelpers.DBWorldQueries;
import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.models.Country;

public class CountryManager implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**
	 * List of Countries.
	 * @return List of Country containing country Data
	 */
	public ArrayList<Country> getCountryData(DBManager dbm)
	{
		if (dbm == null) return null;
		if (!dbm.isConnected())
		{
			if (!dbm.openConnection())
			{
				return null;
			}
		}
		//build a list of country objects using the query
		ArrayList<Country> allCountries = new ArrayList<Country>();
		String query = DBWorldQueries.getCountriesByName();
		try
		{
			ResultSet rs = dbm.ExecuteResultSet(query);
			while (rs.next())
			{
				Country c = new Country();
				c.setCapital(rs.getString("Capital"));
				c.setCode(rs.getString("Code"));
				c.setCode2(rs.getString("Code2"));
				c.setContinent(rs.getString("Continent"));
				c.setGnp(rs.getDouble("GNP"));
				c.setGnpOld(rs.getDouble("GNPOld"));
				c.setGovernmentForm(rs.getString("GovernmentForm"));
				c.setHeadOfState(rs.getString("HeadOfState"));
				c.setIndepYear(rs.getInt("IndepYear"));
				c.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
				c.setLocalName(rs.getString("LocalName"));
				c.setName(rs.getString("Name"));
				c.setPopulation(rs.getInt("Population"));
				c.setRegion(rs.getString("Region"));
				c.setSurfaceArea(rs.getDouble("SurfaceArea"));
				allCountries.add(c);
			}
		}
		catch (Exception ex)
		{
			//log it
			return null;
		}
		return allCountries;
	}
	
	/**
	 * Get the country codes.
	 * @return list of String containing Country Codes
	 */
	public ArrayList<String> getCountryCodes(DBManager dbm)
	{
		if (dbm == null) return null;
		if (!dbm.isConnected())
		{
			if (!dbm.openConnection()) 
			{
				//log it
				//throw new IOException("Could not connect to database and open connection");
				return null;
			}
		}
		
		//build a list of Country Codes
		ArrayList<String> allCountryCodes = new ArrayList<String>();
		String query = DBWorldQueries.getCountryCodes();
		try
		{
			ResultSet rs = dbm.ExecuteResultSet(query);
			while (rs.next())
			{
				String c = rs.getString("Code");
				allCountryCodes.add(c);
			}
			//s.setAttribute("countryCodes", allCountryCodes);
		}
		catch (Exception ex)
		{
			//log it
			//throw new IOException("Query could not be executed for get all codes");
			return null;
		}
		return allCountryCodes;
	}
}
