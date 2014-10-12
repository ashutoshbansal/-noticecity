package com.noticecity.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.noticecity.R;
import com.noticecity.utils.Constants.SIDE_MENU_MODE;


public abstract class BaseFragmentActiviy extends FragmentActivity implements
		OnItemClickListener {

	private DrawerLayout mDrawerLayout;
	private ListView mListView;
	private Object[][] navigationItems = {
			{ "HOME", SIDE_MENU_MODE.HOME, R.color.coupons_text_gray, true },
			{ "MESSAGE", SIDE_MENU_MODE.MESSAGE, R.color.white, false },
			{ "PROFILE", SIDE_MENU_MODE.PROFILE, R.color.white, false },
			{ "LOGOUT", SIDE_MENU_MODE.LOGOUT, R.color.white, false } };

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		mListView = (ListView) findViewById(R.id.left_drawer);
		mListView.setOnItemClickListener(this);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		setAdapter();
	}

	private void setAdapter() {
		mListView.setAdapter(new MyNavigationAdapter());
	}

	class MyNavigationAdapter extends BaseAdapter {
		private LayoutInflater mLayoutInflater;

		public MyNavigationAdapter() {
			mLayoutInflater = LayoutInflater.from(BaseFragmentActiviy.this);
		}

		@Override
		public int getCount() {
			return navigationItems.length;
		}

		@Override
		public Object getItem(int position) {
			if (!(Boolean) navigationItems[position][3]) {
				for (int i = 0; i < navigationItems.length; i++) {
					navigationItems[i][3] = false;
					navigationItems[i][2] = R.color.white;

				}
				navigationItems[position][2] = true;
				navigationItems[position][3] = R.color.coupons_text_gray;
				notifyDataSetChanged();
				return navigationItems[position][1];
			}
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = mLayoutInflater.inflate(R.layout.view_textview,
					parent, false);
			TextView txt = ((TextView) convertView);
			txt.setText((String) navigationItems[position][0]);
			txt.setTextColor(getResources().getColor(R.color.black));
			return convertView;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}

	public abstract void changeFragment(SIDE_MENU_MODE sideMenuMODE);

	public abstract void addFragment(Fragment fragment, boolean addTobackStack,
			String tag);

	public abstract void replaceFragment(Fragment fragment,
			boolean addTobackStack, String tag);

}
