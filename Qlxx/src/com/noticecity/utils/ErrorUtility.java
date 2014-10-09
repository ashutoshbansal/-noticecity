package com.noticecity.utils;

import android.app.Activity;

public class ErrorUtility {

	public static void warnBlankDealCities(Activity activity)
	{
		ToastUtility.showToast(activity, Constants.ToastMesaage.DAILY_DEALS_CITY_NOT_AVAIL);
	}
	
}
