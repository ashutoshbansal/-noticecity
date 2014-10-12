package com.noticecity.application;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import android.app.Application;
import android.content.SharedPreferences;

import com.noticecity.network.RestService;
import com.noticecity.utils.Constants;

public class MyApplication extends Application {
	private RestService restService;
	private SharedPreferences mSharedPreferences;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public RestService getService() {

		if (restService == null) {
			setService();
		}
		return restService;
	}

	private void setService() {

		RequestInterceptor requestInterceptor = new RequestInterceptor() {

			@Override
			public void intercept(RequestFacade request) {
				// TODO Auto-generated method stub

			}
		};
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(Constants.Services.BASE_URL)
				.setRequestInterceptor(requestInterceptor).build();
		restService = restAdapter.create(RestService.class);

	}

	public SharedPreferences getPreference() {
		if (mSharedPreferences == null) {
			mSharedPreferences = getSharedPreferences(
					Constants.NoticeCityPreference.PREFERENCE_NAME,
					MODE_PRIVATE);
		}
		return mSharedPreferences;
	}

}
