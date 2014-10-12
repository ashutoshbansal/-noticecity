package com.noticecity.utils;

import com.google.gson.Gson;

public class JsonUtility {

	
	public static String getJsonFromObject(Object wegoSearches) {
		Gson gson = new Gson();
		String json = gson.toJson(wegoSearches);
		return json;
	}

	
	
}
