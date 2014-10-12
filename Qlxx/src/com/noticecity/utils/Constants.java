package com.noticecity.utils;

public interface Constants {

	public enum SCREEN_MODE {
		MENU_OPTION_1, MENU_OPTION_2, MENU_OPTION_3
	};

	public enum SIDE_MENU_MODE {
		HOME, MESSAGE, PROFILE, LOGOUT
	};

	public enum SERVICE_MODE {
		CREATE_ACCOUNT
	};

	interface Services {

		String BASE_URL = "http://qnectar.net";
		String CREATE_USER = "/createuser";
		String LOGIN_USER = "/login";
	}

	interface ToastMesaage {
		String FIELD_CANT_BLANK = "Field cannot be left blank";
		String INVALID_EMAIL = "Please enter valid email";
		String NAME_CANT_BLANK = "Name cannot be left blank";
		String EMAIL_CANT_BLANK = "Email address cannot be left blank";
		String PASSWORD_CANT_BLANK = "Password cannot be left blank";
		String CONFIRM_PASSWORD_CANT_BLANK = "Confirm Password cannot be left blank";
		String PASSWORD_MISMATCH = "Password mismatch";
		String ACCEPT_TERMS = "Please accept terms & condition";
		String USERNAME = "Username cannot be left blank";
		String LOGIN_SUCCESSFULL = "Login successfull";
		String SIGNING_IN = "Signing in \nPlease Wait.. ";
		String TEAMS_NOT_AVAILABLE = "Unable to load teams";
		String NO_CHANGE_VALUE = "No change in values";
		String PREDICTION_SUBMIT = "Submitting prediction \nPlease wait...";
		String GROUP_NAME_BLANK = "Group name cannot be left blank";
		String EMAIL_NAME_BLANK = "Email cannot be left blank";
		String GROUP_CREATED = "Group created Successfully";
		String CAPTURE_IMAGE_SELECT = "Please select profile image";
		String LOADING_PALYER = "Loading players...";
		String SUBMIT_PLAYER = "Submitting top goal scorer..";
		String GROUP_UPDATED = "Group updated Successfully";
		String DELETE_USER = "Deleting user......";
		String IN_APP_PURCHASED = "In App purchased successfully.";
		String PASSWORD_LENGTH_SHORT = "Password must be at least 6 characters";

		String MISSING_PARAMS = "Please send proper parameter in order to process request";
		String INVITE_CODE_NOT_EXIST = "Invite code doesn't exist";
		String USERNAME_EXISTS = "Username already exists";
		String EMAIL_EXISTS = "Email already exists";
		String SUCCESSFUL_REGISTERATION = "Successfully registered";
		String LOAD_DEALS = "Loading deals..";
		String DAILY_DEALS_CITY_NOT_AVAIL = "Selected country doesn't have any deal cities";
		String SHOP_SEARCH_EMPTY = "Please select one of the product search engine listed below";
		String PLEASE_SELECT_COUNTRY = "Please select your country";
		String SELECT_LOCATION_TO_SEARCH = "Please enter city, region or specific hotel to search";
		String SELECT_CHECK_IN_DAY = "Please select check in date";
		String SELECT_CHECK_OUT_DAY = "Please select check out date";
		String PLEASE_SELECT_ROOMS = "Please select rooms";
		String SHOPPING_SHERLOCK_COUNTRY_SELECTED = "Shopping sherlock country selected";
		String SHOP_SEARCH_ENGINE_NOT_FOUND = "Shop search engine not found";
		String INVALID_INVITE_CODE = "Invalid invite code";
		String SEARCH_FLIGHTS = "searching flight....";
		String BUISNESS_TYPE_BLANK = "Please select type";
		String MODE_BLANK = "Please select profile mode";

		interface ErrorCodeMessage {
			String MISSING_PARAMETER = "Please send proper parameter in order to process request";
			String REQUEST_FAILED = "Request Failed";
			String MISSING_USERNAME_PASSWORD = "Invalid username or password";
		}

	}

	interface NoticeCityPreference {
		String PREFERENCE_NAME = "notice_city_pref";
		String PREFERENCE_USERNAME = "n_username";
		String PREFERENCE_PASSWORD = "n_password";
		String PREFERENCE_REMEMBER_ME = "n_remember_me";
		String PREFERENCE_CITY = "n_city";
		String PREFERENCE_USER_IMAGE = "n_uimage";
		String PREFERENCE_PHONE_NUMBER = "n_phone_number";
		String PREFERENCE_EMAIL = "n_email";
		String PREFERENCE_PROFILE_TYPE = "n_profile_type";
		String PREFERENCE_MODE_TYPE = "n_mode_type";
		String PREFERENCE_REMEMBER_USERNAME = "n_rem_user";
		String PREFERENCE_REMEMBER_PASSWORD = "n_rem_pass";
	}

	interface RequestCode {
		int CREATE_ACCOUNT = 213;
		int SCAN_ACITIVITY = 214;
	}

}
