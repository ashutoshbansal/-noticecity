package com.noticecity.utils;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class JsonUtility {

	public static String getDailyDeals(String country, String city, String sortMethod) {
		JSONObject jsonObject = new JSONObject();
		

		return null;

	}



	


	public static String getCountries() {
		JSONObject jsonObject = new JSONObject();
		

		return null;

	}

	public static String getTripAdvisor(Object wegoSearches) {
		Gson gson = new Gson();
		String json = gson.toJson(wegoSearches);
		return json;
	}

	
	
}
