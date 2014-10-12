package com.noticecity.network;

import android.app.Activity;
import android.app.Dialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.noticecity.activity.CreateAccountActivity;
import com.noticecity.exception.MyException;
import com.noticecity.utils.Constants.SCREEN_MODE;
import com.noticecity.utils.Constants.SERVICE_MODE;
import com.noticecity.widgets.ProgressHUD;

;
public class MyNetwork<T> implements Callback<T> {

	private Dialog mDialog;
	private MyRetroftCallBack myRetroftCallBack;
	private Activity activity;
	private SERVICE_MODE screenMode;

	public MyNetwork(Boolean isDialog, MyRetroftCallBack myRetroftCallBack,
			Activity activity, SERVICE_MODE screenMode, String loadingMessage) {
		this.myRetroftCallBack = myRetroftCallBack;
		this.activity = activity;
		this.screenMode = screenMode;
		if (isDialog) {
			mDialog=ProgressHUD.show(activity, loadingMessage, false, false, null);
		}
	}

	public MyNetwork(Boolean isDialog, MyRetroftCallBack myRetroftCallBack,
			Activity activity, SERVICE_MODE createAccount) {
		this(isDialog, myRetroftCallBack, activity, createAccount, "Loading..");

	}

	

	@Override
	public void failure(RetrofitError arg0) {
		dismissDialog();
		MyException.getInstance().handleException(arg0);
	}

	@Override
	public void success(T arg0, Response arg1) {
		dismissDialog();
		myRetroftCallBack.onSuccess(arg0, screenMode);
	}

	private void dismissDialog() {
		if (mDialog != null) {
			mDialog.dismiss();
		}
	}

}
