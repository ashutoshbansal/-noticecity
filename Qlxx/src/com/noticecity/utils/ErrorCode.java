package com.noticecity.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class ErrorCode {
	private static Dialog create;

	public static void processErrorCode(Activity activity, int errorCode,
			boolean showDialog) {
		// Missing parameter
		if (errorCode == 0) {
			AlertDialog.Builder builder = new AlertDialog.Builder(activity);

			builder.setTitle(Constants.ToastMesaage.ErrorCodeMessage.REQUEST_FAILED);
			builder.setMessage(Constants.ToastMesaage.ErrorCodeMessage.MISSING_USERNAME_PASSWORD);
			builder.setPositiveButton("Ok", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					create.dismiss();
				}
			});
			create = builder.create();
			create.show();
		} else if (errorCode == 2) {

		}

	}

	public static void processNetworkErrorCode(Activity activity, int errorCode) {
		switch (errorCode) {
		// Bad request - Something wrong with request
		case 400:

			break;
		// Forbiden - The limit of Api calls exceeded
		case 403:

			break;
		// Unprocessable Entity - Something wrong with request json
		case 422:

			break;

		// Internal Server Error
		case 500:

			break;
		default:
			break;
		}
	}

}
