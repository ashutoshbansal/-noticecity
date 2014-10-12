package com.noticecity.utils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;

public class ToastUtility {

	public static void showToast(Activity activity, String text) {
		try {
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showToastContext(Context activity, String text) {
		try {
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showToast(Activity activity, Throwable throwable) {
		try {
			Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_LONG)
					.show();
		} catch (BadTokenException badTokenException) {
			badTokenException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
