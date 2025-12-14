package com.worldmanager.modelmanagers;

import java.io.Serializable;
import java.sql.ResultSet;

import com.worldmanager.dbhelpers.DBWorldQueries;
import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.models.WebUser;

public class WebUserManager implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Get a web user if there is a match using uid/pwd combo
	 * @param dbm DBManager
	 * @param uid userid
	 * @param pwd password
	 * @return null if no match or bad input else matching WebUser
	 */
	public WebUser getWebUserByCredentials(DBManager dbm, String uid, String pwd)
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
		
		WebUser wu = new WebUser();
		//see if there is a matching WebUser
		String query = DBWorldQueries.getWebUserByUsernameAndPassword(uid, pwd);
		try
		{
			ResultSet rs = dbm.ExecuteResultSet(query);
			while (rs.next())
			{
				wu.setId(rs.getInt("ID"));
				wu.setUserId(rs.getString("UserName"));
				wu.setPassword(rs.getString("Password"));
				wu.setAuthLevel(rs.getInt("AuthLevel"));
			}
			return wu;
		}
		catch (Exception ex)
		{
			//log it
			return wu;
		}
	}

	public boolean userIsValid(WebUser wu)
	{
		if (wu == null) return false;
		if (wu.getUserId() == null || wu.getUserId().length() == 0) return false;
		if (wu.getPassword() == null || wu.getPassword().length() == 0) return false;
		if (wu.getAuthLevel() < 1) return false;
		return true;
	}
	
	public boolean userIsAdmin(WebUser wu)
	{
		if (!userIsValid(wu)) return false;
		if (wu.getAuthLevel() < 2) return false;
		return true;
	}

	public boolean validateParams(String uid, String pwd)
	{
		if (uid == null) return false;
		if (pwd == null) return false;
		if (uid.length() == 0 || pwd.length() == 0)
		{
			//can't log in
			return false;
		}
		return true;
	}
}
