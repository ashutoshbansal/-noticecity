package com.noticecity.network;

import retrofit.RetrofitError;
import com.noticecity.utils.Constants.SERVICE_MODE;
public interface MyRetroftCallBack {

	 <T> void onSuccess(T t, SERVICE_MODE screenMode);

	 void onFailure(RetrofitError retrofitError,
			SERVICE_MODE screenMode);

}
