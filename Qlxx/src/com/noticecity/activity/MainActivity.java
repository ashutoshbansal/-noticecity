package com.noticecity.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.noticecity.R;
import com.noticecity.fragment.HomeFragment;
import com.noticecity.utils.Constants.SIDE_MENU_MODE;

public class MainActivity extends BaseFragmentActiviy {

	@Override
	protected void onCreate(Bundle arg0) {
		setContentView(R.layout.activity_main);
		super.onCreate(arg0);
		addFragment(HomeFragment.newInstance(), true, null);
	}

	@Override
	public void changeFragment(SIDE_MENU_MODE sideMenuMODE) {
		getSupportFragmentManager().popBackStack(null,
				FragmentManager.POP_BACK_STACK_INCLUSIVE);
		FragmentTransaction beginTransaction = getSupportFragmentManager()
				.beginTransaction();
		switch (sideMenuMODE) {

		case HOME:
			beginTransaction.add(HomeFragment.newInstance(), null);
			break;

		case MESSAGE:

			break;

		case PROFILE:

			break;

		case LOGOUT:

			break;

		default:
			break;
		}
		beginTransaction.addToBackStack(null);
		beginTransaction.commit();
	}

	@Override
	public void addFragment(Fragment fragment, boolean addTobackStack,
			String tag) {

		FragmentTransaction beginTransaction = getSupportFragmentManager()
				.beginTransaction();
		beginTransaction.add(R.id.content_frame, fragment, tag);
		if (addTobackStack)
			beginTransaction.addToBackStack(tag);

		beginTransaction.commit();
	}

	@Override
	public void replaceFragment(Fragment fragment, boolean addTobackStack,
			String tag) {
		getSupportFragmentManager().popBackStack(null,
				FragmentManager.POP_BACK_STACK_INCLUSIVE);
		FragmentTransaction beginTransaction = getSupportFragmentManager()
				.beginTransaction();
		beginTransaction.replace(R.id.content_frame, fragment, tag);
		if (addTobackStack)
			beginTransaction.addToBackStack(tag);

		beginTransaction.commit();

	}

}
