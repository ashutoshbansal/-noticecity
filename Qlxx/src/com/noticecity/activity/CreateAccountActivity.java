package com.noticecity.activity;

import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Dialog;
import android.os.Bundle;
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

public class CreateAccountActivity<T> extends BaseActivity<T> implements OnClickListener, SoftKeyboardListener
{
	private static final int[] CLICK_ID = { R.id.create_account_id };
	private KeyboardDetectorScrollView keyboardDetectorScrollView;
	private View spaceDivider;
	private CheckBox mCheckBox;
	private String deviceId;

	@Override
	public void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.activity_createaccount_layout);
		setOnClickListener(CLICK_ID);
		keyboardDetectorScrollView = (KeyboardDetectorScrollView) findViewById(R.id.c_register_scrollview);
		spaceDivider = findViewById(R.id.c_parent_signin);
		keyboardDetectorScrollView.setSoftKeyboardListener(this);
		mCheckBox = (CheckBox) findViewById(R.id.checkbox_id);
	}

	
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.create_account_id:
			boolean filledInputValues = isFilledInputValues();
			if (filledInputValues)
			{
				EditText inviteView = (EditText) findViewById(R.id.invite_code_id);
				EditText usernameView = (EditText) findViewById(R.id.username_id);
				EditText emailView = (EditText) findViewById(R.id.email_address_id);
				EditText passwordView = (EditText) findViewById(R.id.password_id);
				

			}
			break;

		default:
			break;
		}
	}

	private boolean isFilledInputValues()
	{

		if (Utility.isNotEmptyError(CreateAccountActivity.this, (EditText) findViewById(R.id.invite_code_id),
				Constants.ToastMesaage.FIELD_CANT_BLANK))
		{
			if (Utility.isNotEmptyError(CreateAccountActivity.this, (EditText) findViewById(R.id.username_id),
					Constants.ToastMesaage.FIELD_CANT_BLANK, "Username", 4))
			{
				if (Utility.isNotEmptyError(CreateAccountActivity.this, (EditText) findViewById(R.id.email_address_id),
						Constants.ToastMesaage.FIELD_CANT_BLANK))
				{

					if (Utility.validateEmail(CreateAccountActivity.this, (EditText) findViewById(R.id.email_address_id)))
					{
						if (Utility.isNotEmptyError(CreateAccountActivity.this, (EditText) findViewById(R.id.password_id),
								Constants.ToastMesaage.FIELD_CANT_BLANK, "Password", 6))
						{
							if (mCheckBox.isChecked())
							{
								return true;
							}
							else
							{
								Utility.ShowToast(this, "Please accept terms and condition");
							}
						}

					}

				}

			}

		}
		return false;

	}

	
	@Override
	public void onSoftKeyboardShow()
	{
		keyboardDetectorScrollView.post(new Runnable()
		{

			@Override
			public void run()
			{
				keyboardDetectorScrollView.smoothScrollTo(0, (int) spaceDivider.getY());
			}
		});
	}

	@Override
	public void onSoftKeyboardHide()
	{

	}

	/* (non-Javadoc)
	 * @see com.noticecity.retrofitcore.MyNetworkCallBack#onSuccess(android.app.Dialog, java.lang.Object, retrofit.client.Response, com.noticecity.utils.Constants.SERVICE_MODE)
	 */
	@Override
	public void onSuccess(Dialog progressDialog, T t, Response arg1, SERVICE_MODE serviceMode)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.noticecity.retrofitcore.MyNetworkCallBack#onFailure(android.app.Dialog, java.lang.Object, retrofit.RetrofitError, com.noticecity.utils.Constants.SERVICE_MODE)
	 */
	@Override
	public void onFailure(Dialog progressDialog, T t, RetrofitError arg1, SERVICE_MODE serviceMode)
	{
		// TODO Auto-generated method stub
		
	}

}
