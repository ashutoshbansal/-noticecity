package com.noticecity;

import retrofit.RetrofitError;
import android.os.Bundle;
import android.view.Menu;

import com.noticecity.R;

public class LoginActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public <T, SCREEN_MODE> void onSuccess(T t, SCREEN_MODE screenMode) {
		
	}

	@Override
	public <SCREEN_MODE> void onFailure(RetrofitError retrofitError,
			SCREEN_MODE screenMode) {
		// TODO Auto-generated method stub
	
		
		
		
		
	}

}
