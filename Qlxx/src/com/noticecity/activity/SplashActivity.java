/**
 *  Project : ShoppingSherlock
 *  Author : root
 *  Creation Date : 29-Aug-2014
 *  Description : @TODO
 */
package com.noticecity.activity;

import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.noticecity.R;
import com.noticecity.utils.Constants;
import com.noticecity.utils.Constants.SERVICE_MODE;

public class SplashActivity extends BaseActivity
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shoppingsherlock.activity.BaseActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
		{

			@Override
			public void run()
			{
				SharedPreferences preference = application.getPreference();
				String username = preference.getString(Constants.NoticeCityPreference.PREFERENCE_USERNAME, "");
				int length = username == null ? 0 : username.length();
				if (length > 0)
				{

				}
				else
				{
					startSherlockActivity(LoginActivity.class, null);
				}
				finish();

			}
		}, 3000);

	}

	@Override
	public <T> void onSuccess(T t, SERVICE_MODE screenMode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailure(RetrofitError retrofitError, SERVICE_MODE screenMode) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
