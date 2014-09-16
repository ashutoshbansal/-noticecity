package com.noticecity.exception;

import android.util.Log;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MyException {
	private static final String TAG = MyException.class.getSimpleName();
	private static MyException myException;

	public static MyException getInstance() {
		if (myException == null) {
			myException = new MyException();
		}
		return myException;
	}

	public void handleException(RetrofitError retrofitError) {
		if (retrofitError != null) {

			Response response = retrofitError.getResponse();
			if (response != null) {
				int status = response.getStatus();
				String reason = response.getReason();
				Log.d(TAG, "reason is: " + reason);
				switch (status) {
				// Bad Request
				case 400:

					break;
				// Not authorized user
				case 401:

					break;
				// payment required
				case 402:

					break;
				// The request was a valid request, but the server is refusing
				// to respond to it. Unlike a 401 Unauthorized response,
				// authenticating will make no difference.
				case 403:

					break;
				// The requested resource could not be found but may be
				// available again in the future. Subsequent requests by the
				// client are permissible.
				case 404:

					break;
				// A request was made of a resource using a request method not
				// supported by that resource; for example, using GET on a form
				// which requires data to be presented via POST, or using PUT on
				// a read-only resource.
				case 405:

					break;
				// A generic error message, given when an unexpected condition
				// was encountered and no more specific message is suitable.
				case 500:

					break;

				default:
					break;
				}

			}
		}

	}

}
