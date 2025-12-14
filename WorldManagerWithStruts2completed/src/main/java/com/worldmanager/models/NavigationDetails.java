package com.worldmanager.models;

import java.io.Serializable;

public class NavigationDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private String link;
	private String friendlyText;

	public NavigationDetails()
	{
		//do nothing
	}
	
	public String getLink()
	{
		return link;
	}
	public void setLink(String value)
	{
		link = value;
	}
	public String getText()
	{
		return friendlyText;
	}
	public void setText(String value)
	{
		friendlyText = value;
	}
	
	public String toString()
	{
		return String.format("Link: %s\tFriendly: %s\n"
				, getLink()
				, getText());
	}
}
