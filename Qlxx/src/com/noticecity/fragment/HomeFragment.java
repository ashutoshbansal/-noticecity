package com.noticecity.fragment;

import com.noticecity.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends BaseFragment {
	private TextView sideNavigationView;
	private TextView titleView;

	public static HomeFragment newInstance() {
		return new HomeFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		sideNavigationView = (TextView) view
				.findViewById(R.id.side_navigation_id);
		titleView = (TextView) view.findViewById(R.id.title_id);
		titleView.setText("HOME");
		return view;
	}

}
