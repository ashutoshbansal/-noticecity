/**
 * Project : FIFA
 * Author : ashutosh
 * Creation Date : Mar 27, 2014
 * Description : @TODO
 */
package com.noticecity.retrofitcore;

import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Dialog;
import com.noticecity.utils.Constants.SERVICE_MODE;


public interface MyNetworkCallBack<T>
{
	void onSuccess(Dialog progressDialog, T t, Response arg1, SERVICE_MODE serviceMode);

	void onFailure(Dialog progressDialog, T t, RetrofitError arg1, SERVICE_MODE serviceMode);

}
