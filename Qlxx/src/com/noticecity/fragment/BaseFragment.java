package com.noticecity.fragment;

import com.noticecity.activity.MainActivity;
import com.noticecity.application.MyApplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {
	MainActivity mActivity;
	MyApplication myApplication;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (MainActivity) activity;
		myApplication = (MyApplication) activity.getApplication();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	

	
	
}
