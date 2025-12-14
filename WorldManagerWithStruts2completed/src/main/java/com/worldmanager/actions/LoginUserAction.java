package com.worldmanager.actions;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.worldmanager.dbhelpers.DBWorldQueries;
import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.modelmanagers.WebUserManager;
import com.worldmanager.models.WebUser;

public class LoginUserAction extends ActionSupport implements SessionAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String pwd;
	private int authLevel;
	private boolean rememberMe;
	private Map<String, Object> s;
	private HttpServletResponse sr;
	
	public String getUid()
	{
		return uid;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public int getAuthLevel()
	{
		return authLevel;
	}
	public void setAuthLevel(int al)
	{
		authLevel = al;
	}
	public boolean getRememberMe()
	{
		return this.rememberMe;
	}
	public void setRememberMe(boolean rememberMe)
	{
		this.rememberMe = rememberMe;
	}
	
	public String execute()
	{
		DBManager dbm = null;
		Map<String, Object> appVars = (Map<String, Object>)ActionContext.getContext().get("application");
		for (Map.Entry<String, Object> e : appVars.entrySet())
		{
			if (e.getKey().equals("WorldDBManager"))
			{
				dbm = (DBManager)e.getValue();
			}
		}
		if (dbm == null)
		{
			return ActionSupport.ERROR;
		}
		if (!dbm.isConnected())
		{
			if (!dbm.openConnection()) 
			{
				//log it
				return ActionSupport.ERROR;
			}
		}
		
		WebUserManager wum;
		WebUser wu = null;
		try
		{
			//get a webuser manager
			wum = new WebUserManager();
			wu = wum.getWebUserByCredentials(dbm, getUid(), getPwd());
			s.put("authorized_user", wu);
		}
		catch (Exception ex)
		{
			s.put("authorized_user", null);
			return ActionSupport.ERROR;
		}
		
		//try to set cookie if user said to remember them
		if (getRememberMe() == true)
		{
			int cookieLife = 3600*24*7; //7 days
			Cookie uidCook = new Cookie("credentials_uid",uid);
			uidCook.setMaxAge(cookieLife);  //7 days
			sr.addCookie(uidCook);
			Cookie pwdCook = new Cookie("credentials_pwd",pwd);
			uidCook.setMaxAge(cookieLife);  //7 days
			sr.addCookie(pwdCook);
		}
		
		return ActionSupport.SUCCESS;
	}
	
	public void validate()
	{
		if (getUid() == null || getUid().equals(""))
		{
			addFieldError("uid", "User Name is Required");
		}
		else if (getPwd() == null || getPwd().equals(""))
		{
			addFieldError("pwd", "Password is required");
		}
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		s = arg0;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		sr = arg0;
	}
}
