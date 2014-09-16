package com.noticecity.network;

import retrofit.RetrofitError;

public interface MyRetroftCallBack {

	<T, SCREEN_MODE> void onSuccess(T t, SCREEN_MODE screenMode);

	<SCREEN_MODE> void onFailure(RetrofitError retrofitError,
			SCREEN_MODE screenMode);

}
