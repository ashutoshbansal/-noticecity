package com.noticecity.network;

import retrofit.http.Body;
import retrofit.http.PUT;
import retrofit.mime.TypedInput;

import com.noticecity.model.Response;
import com.noticecity.utils.Constants;

public interface RestService {

	@PUT(Constants.Services.LOGIN_USER)
	public void loginUser(@Body TypedInput typedInput,MyNetwork<Response> callback);

	
	
	@PUT(Constants.Services.CREATE_USER)
	public void createUser(@Body TypedInput typedInput,MyNetwork<Response> callback);
	
}
