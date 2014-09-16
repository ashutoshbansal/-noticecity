package com.noticecity.application;

import retrofit.RequestInterceptor;
import retrofit.RequestInterceptor.RequestFacade;
import retrofit.RestAdapter;

import com.noticecity.retrofitcore.RestService;
import com.noticecity.utils.Constants;

import android.app.Application;

public class MyApplication extends Application {
	private RestService restService;

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

}
