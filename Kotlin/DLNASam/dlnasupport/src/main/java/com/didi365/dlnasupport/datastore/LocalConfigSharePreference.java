package com.didi365.dlnasupport.datastore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LocalConfigSharePreference {

	public static final String preference_name = "LocalConfigSharePreference";
	public static final String dev_name = "dev_name";
	
	public static boolean commintDevName(Context context, String devName){
	
		SharedPreferences sharedPreferences = context.getSharedPreferences(preference_name, 0);
		Editor editor = sharedPreferences.edit();
		editor.putString(dev_name, devName);
		editor.commit();
		return true;
	}
	
	public static String getDevName(Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(preference_name, 0);
		String value = sharedPreferences.getString(dev_name, "dlna_didi365222");
		return value;
	}
	
}
