package com.noticecity;

import android.app.Activity;
import android.os.Bundle;

import com.noticecity.application.MyApplication;
import com.noticecity.network.MyRetroftCallBack;

public abstract class BaseActivity extends Activity implements MyRetroftCallBack{

	public MyApplication myApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myApplication = (MyApplication) getApplication();
	}

}
