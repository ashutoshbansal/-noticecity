package com.noticecity.activity;

import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;

import com.noticecity.R;
import com.noticecity.utils.Constants;
import com.noticecity.utils.Constants.SERVICE_MODE;
import com.noticecity.utils.Utility;
import com.noticecity.widgets.KeyboardDetectorScrollView;
import com.noticecity.widgets.KeyboardDetectorScrollView.SoftKeyboardListener;



public class LoginActivity extends BaseActivity implements OnClickListener, SoftKeyboardListener {
	private static final String TAG = LoginActivity.class.getSimpleName();
	int CLICKID[] = { R.id.createaccount_id, R.id.signin_id,R.id.forgot_password_id };
	private KeyboardDetectorScrollView keyboardDetectorScrollView;
	private View spaceView;
	private CheckBox mCheckBox;
	private String deviceId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_layout);
		setOnClickListener(CLICKID);
		keyboardDetectorScrollView = (KeyboardDetectorScrollView) findViewById(R.id.keyboard_scrollview);
		keyboardDetectorScrollView.setSoftKeyboardListener(this);
		spaceView = findViewById(R.id.parent_signin);
		mCheckBox = (CheckBox) findViewById(R.id.checkbox_id);
		checkPreferences();

	}

	

	private void checkPreferences() {
		EditText usernameEditText = (EditText) findViewById(R.id.username_id);
		EditText passwordEditText = (EditText) findViewById(R.id.password_id);

		SharedPreferences preference = application.getPreference();
		boolean rememberMe = preference.getBoolean(Constants.NoticeCityPreference.PREFERENCE_REMEMBER_ME, false);
		if (rememberMe) {
			String username = preference.getString(Constants.NoticeCityPreference.PREFERENCE_REMEMBER_USERNAME, "");
			String password = preference.getString(Constants.NoticeCityPreference.PREFERENCE_REMEMBER_PASSWORD, "");
			usernameEditText.setText(username);
			passwordEditText.setText(password);
		}
		mCheckBox.setChecked(rememberMe);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.createaccount_id:
			startActivityForResult(new Intent(LoginActivity.this, CreateAccountActivity.class), Constants.RequestCode.CREATE_ACCOUNT);
			break;

		case R.id.signin_id:
			// startActivity(new Intent(this, ShoppingFragmentActivity.class));
			if (Utility.isNotEmptyError(this, (EditText) findViewById(R.id.username_id), Constants.ToastMesaage.FIELD_CANT_BLANK)) {
				if (Utility.isNotEmptyError(this, (EditText) findViewById(R.id.password_id), Constants.ToastMesaage.FIELD_CANT_BLANK)) {
					EditText usernameEditText = (EditText) findViewById(R.id.username_id);
					EditText passwordEditText = (EditText) findViewById(R.id.password_id);
					String username = usernameEditText.getText().toString();
					String password = passwordEditText.getText().toString();
					//ShoppingService shoppingRestService = sherlockApplication.getShoppingRestService();
					//shoppingRestService.doLogin(username, password, latitude+"", longitude+"", deviceId, new ResponseCallBack<LoginResponse>(this, this, true, v, SERVICE_MODE.LOGIN));
				}
			}

			break;
			
		case R.id.forgot_password_id:
			Intent intent = new Intent(Intent.ACTION_VIEW);
//			String url=Constants.NetworkServices.FORGOT_PASSWORD;
//			try {
//				 url = new String(url.getBytes("utf-8"));
//				Log.d(TAG, "url encode ----------- " + url);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			Uri parse = Uri.parse(url);
//			intent.setData(parse);

			startActivity(intent);
			break;
			
		default:
			break;
		}
	}

	
	@Override
	public void onSoftKeyboardShow() {
		keyboardDetectorScrollView.post(new Runnable() {

			@Override
			public void run() {
				keyboardDetectorScrollView.smoothScrollTo(0, (int) spaceView.getY());
			}
		});
	}

	@Override
	public void onSoftKeyboardHide() {

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
