package com.noticecity.activity;

import retrofit.RetrofitError;
import retrofit.http.POST;
import retrofit.mime.TypedInput;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;

import com.noticecity.R;
import com.noticecity.model.Response;
import com.noticecity.model.UserRegister;
import com.noticecity.network.MyNetwork;
import com.noticecity.utils.Constants;
import com.noticecity.utils.Constants.SERVICE_MODE;
import com.noticecity.utils.JsonUtility;
import com.noticecity.utils.Utility;
import com.noticecity.widgets.KeyboardDetectorScrollView;
import com.noticecity.widgets.KeyboardDetectorScrollView.SoftKeyboardListener;
import com.noticecity.widgets.MyDefaultSpinner;

public class CreateAccountActivity<T> extends BaseActivity<T> implements
		OnClickListener, SoftKeyboardListener {
	private static final int[] CLICK_ID = { R.id.create_account_id };
	private static final String TAG = CreateAccountActivity.class
			.getSimpleName();
	private KeyboardDetectorScrollView keyboardDetectorScrollView;
	private View spaceDivider;
	private CheckBox mCheckBox;
	private EditText phoneNumberView;
	private EditText usernameView;
	private EditText emailView;
	private EditText passwordView;
	private EditText cityName;
	private MyDefaultSpinner typeSpinner;
	private MyDefaultSpinner modeSpinner;

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_createaccount_layout);
		setOnClickListener(CLICK_ID);
		keyboardDetectorScrollView = (KeyboardDetectorScrollView) findViewById(R.id.c_register_scrollview);
		spaceDivider = findViewById(R.id.c_parent_signin);
		keyboardDetectorScrollView.setSoftKeyboardListener(this);
		mCheckBox = (CheckBox) findViewById(R.id.checkbox_id);
		phoneNumberView = (EditText) findViewById(R.id.invite_code_id);
		usernameView = (EditText) findViewById(R.id.username_id);
		emailView = (EditText) findViewById(R.id.email_address_id);
		passwordView = (EditText) findViewById(R.id.password_id);
		cityName = (EditText) findViewById(R.id.cityname_id);
		typeSpinner = (MyDefaultSpinner) findViewById(R.id.type_id);
		modeSpinner = (MyDefaultSpinner) findViewById(R.id.mode_id);
		setTypeAdapter();
		setModeAdapter();
	}

	@Override
	public void onClick(View v) {
		startActivity(new Intent(this, MainActivity.class));
//		switch (v.getId()) {
//		case R.id.create_account_id:
//			boolean filledInputValues = isFilledInputValues();
//			if (filledInputValues) {
//				UserRegister userRegister = new UserRegister();
//				userRegister.notcityid = phoneNumberView.getText().toString();
//				userRegister.email = emailView.getText().toString();
//				userRegister.password = passwordView.getText().toString();
//				userRegister.notcityname = cityName.getText().toString();
//				userRegister.name = usernameView.getText().toString();
//				userRegister.notcitytype = getCityAccessType();
//				userRegister.notcity_default_access_type = getProfileMode();
//
//				String json = JsonUtility.getJsonFromObject(userRegister);
//				Log.d(TAG, "final json is " + json);
//				TypedInput typedInputJson = Utility.getTypedInputJson(json);
//				application.getService().createUser(
//						typedInputJson,
//						new MyNetwork<Response>(true, this, this,
//								SERVICE_MODE.CREATE_ACCOUNT));
//			}
//			break;
//
//		default:
//			break;
//		}
	}

	private String getCityAccessType() {
		switch (typeSpinner.getSelectedItemPosition()) {
		case 0:
			return "M";
		case 1:
			return "S";

		default:
			return "S";
		}
	}

	private String getProfileMode() {
		switch (modeSpinner.getSelectedItemPosition()) {
		case 0:
			return "PR";
		case 1:
			return "PU";

		default:
			return "PR";
		}
	}

	private boolean isFilledInputValues() {

		if (Utility.isNotEmptyError(CreateAccountActivity.this,
				(EditText) findViewById(R.id.invite_code_id),
				Constants.ToastMesaage.FIELD_CANT_BLANK)) {
			if (Utility.isNotEmptyError(CreateAccountActivity.this,
					(EditText) findViewById(R.id.username_id),
					Constants.ToastMesaage.FIELD_CANT_BLANK, "Username", 4)) {
				if (Utility.isNotEmptyError(CreateAccountActivity.this,
						(EditText) findViewById(R.id.email_address_id),
						Constants.ToastMesaage.FIELD_CANT_BLANK)) {

					if (Utility.validateEmail(CreateAccountActivity.this,
							(EditText) findViewById(R.id.email_address_id))) {
						if (Utility.isNotEmptyError(CreateAccountActivity.this,
								(EditText) findViewById(R.id.password_id),
								Constants.ToastMesaage.FIELD_CANT_BLANK,
								"Password", 6)) {
							if (Utility.isNotEmptyError(
									CreateAccountActivity.this, cityName,
									Constants.ToastMesaage.FIELD_CANT_BLANK,
									"City", 2)) {
								if (typeSpinner.getSelectedItemPosition() >= 0) {
									if (modeSpinner.getSelectedItemPosition() >= 0) {
										if (mCheckBox.isChecked()) {
											return true;
										} else {
											Utility.ShowToast(this,
													"Please accept terms and condition");
										}
									} else {
										Utility.ShowToast(
												this,
												Constants.ToastMesaage.MODE_BLANK);
									}
								} else {
									Utility.ShowToast(
											this,
											Constants.ToastMesaage.BUISNESS_TYPE_BLANK);
								}
							}
						}

					}

				}

			}

		}
		return false;

	}

	@Override
	public void onSoftKeyboardShow() {
		keyboardDetectorScrollView.post(new Runnable() {

			@Override
			public void run() {
				keyboardDetectorScrollView.smoothScrollTo(0,
						(int) spaceDivider.getY());
			}
		});
	}

	private void setTypeAdapter() {
		String[] items = getResources().getStringArray(R.array.type);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, items);
		typeSpinner.setAdapter(adapter);
	}

	private void setModeAdapter() {
		String[] items = getResources().getStringArray(R.array.mode);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, items);
		modeSpinner.setAdapter(adapter);

	}

	@Override
	public void onSoftKeyboardHide() {

	}

	@Override
	public <T> void onSuccess(T t, SERVICE_MODE screenMode) {
		if (t != null) {
			switch (screenMode) {
			case CREATE_ACCOUNT:
				if (t instanceof Response) {
					Response response = (Response) t;
					if (response.result != null
							&& response.result.equalsIgnoreCase("success")) {
						SharedPreferences preference = application
								.getPreference();
						Editor edit = preference.edit();
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_NAME,
								usernameView.getText().toString());
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_CITY,
								cityName.getText().toString());
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_EMAIL,
								emailView.getText().toString());
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_PASSWORD,
								passwordView.getText().toString());
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_PHONE_NUMBER,
								phoneNumberView.getText().toString());
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_PROFILE_TYPE,
								(String) typeSpinner.getSelectedItem());
						edit.putString(
								Constants.NoticeCityPreference.PREFERENCE_MODE_TYPE,
								(String) modeSpinner.getSelectedItem());
						edit.commit();
						startActivity(new Intent(this, MainActivity.class));
					}
				}
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void onFailure(RetrofitError retrofitError, SERVICE_MODE screenMode) {
		// TODO Auto-generated method stub

	}

}
