package com.worldmanager.utilities;

public class WorldManagerUtils {

	public static boolean stringNullOrEmpty(String x)
	{
		if (x == null) return true;
		if (x.length() == 0) return true;
		return false;
	}
}
