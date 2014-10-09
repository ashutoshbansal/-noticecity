package com.noticecity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;

import com.noticecity.application.MyApplication;
import com.noticecity.retrofitcore.MyNetworkCallBack;

public abstract class BaseActivity<T> extends Activity implements MyNetworkCallBack<T> {
	private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
	private static final String TAG = BaseActivity.class.getSimpleName();
	protected MyApplication application;
	// A request to connect to Location Services


	// Stores the current instantiation of the location client in this object

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		application = (MyApplication) getApplication();

	}

	public void setOnClickListener(int[] clickId) {
		int size = clickId == null ? 0 : clickId.length;
		for (int i = 0; i < size; i++) {
			findViewById(clickId[i]).setOnClickListener((OnClickListener) this);
		}

	}

	protected void startSherlockActivity(Class nextClass, Bundle extras) {
		Intent intent = new Intent(this, nextClass);
		if (extras != null)
			intent.putExtras(extras);
		startActivity(intent);

	}


}
