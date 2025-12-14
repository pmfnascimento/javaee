package com.worldmanager.modelmanagers;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.worldmanager.dbhelpers.DBWorldQueries;
import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.models.City;
import com.worldmanager.utilities.WorldManagerUtils;

public class CityManager implements Serializable
{
	private static final long serialVersionUID = 1L;
	public CityManager()
	{
		//do nothing.
	}
	
	/**
	 * Get the US Cities for display
	 * @param dbm the Manager for the DB
	 * @return the list of US Cities
	 */
	public ArrayList<City> getUSCitiesByDistrictByPopulation(DBManager dbm)
	{
		//get the cities and direct on
		if (dbm == null) return null;
		if (!dbm.isConnected())
		{
			if (!dbm.openConnection()) 
			{
				//log it...
				return null;
			}
		}
			
		//build a list of city objects using the query
		ArrayList<City> allCities = new ArrayList<City>();
		String query = DBWorldQueries.getCitiesByDistrictByPopulation();
		try
		{
			ResultSet rs = dbm.ExecuteResultSet(query);
			while (rs.next())
			{
				City c = new City();
				c.setId(rs.getInt("ID"));
				c.setName(rs.getString("Name"));
				c.setCountryCode(rs.getString("CountryCode"));
				c.setDistrict(rs.getString("District"));
				c.setPopulation(rs.getInt("Population"));
				allCities.add(c);
			}
		}
		catch (Exception ex)
		{
			//log it
			return null;
		}
		return allCities;
	}

	/**
	 * Insert a city.
	 * @param dbm DBManager
	 * @param name City Name 
	 * @param countryCode country code
	 * @param district district
	 * @param population population
	 * @return the created city object
	 */
	public City insertCity(DBManager dbm, String name, String countryCode, String district, int population)
	{
		//insert a city
	    if (dbm == null) return null;
		if (!dbm.isConnected())
		{
			if (!dbm.openConnection()) 
			{
				//log it
				return null;
			}
		}
		if (WorldManagerUtils.stringNullOrEmpty(name) || WorldManagerUtils.stringNullOrEmpty(countryCode) 
				|| WorldManagerUtils.stringNullOrEmpty(district) || population <= 0)
		{
			return null;
		}
		
		//make the city to be added
		City c = new City();
		c.setCountryCode(countryCode);
		c.setDistrict(district);
		c.setId(-1);
		c.setName(name);
		c.setPopulation(population);
		
		//TODO: add a check to make sure not duplicate instead of relying on constraints
		//      which may or may not exist
		
		//add the city
		String query = DBWorldQueries.insertCity(c);
		try
		{
			//execute
			dbm.ExecuteNonQuery(query);
		
			//pull the city
			query = DBWorldQueries.getCityByAllButID(c);
			ResultSet rs = dbm.ExecuteResultSet(query);
			while (rs.next())
			{
				c.setCountryCode(rs.getString("CountryCode"));
				c.setDistrict(rs.getString("District"));
				c.setId(rs.getInt("ID"));
				c.setName(rs.getString("Name"));
				c.setPopulation(rs.getInt("Population"));
			}
		}
		catch (Exception ex)
		{
			//log it
			return null;
		}			
		return c;
	}
	
	/**
	 * 
	 * @param dbm DBManager
	 * @param c City to add
	 * @return the created city object
	 */
	public City insertCity(DBManager dbm, City c)
	{
		return insertCity(dbm, c.getName(), c.getCountryCode(), c.getDistrict(), c.getPopulation());
	}
}
