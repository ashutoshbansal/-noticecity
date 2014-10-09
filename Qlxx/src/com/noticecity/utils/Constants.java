package com.noticecity.utils;

public interface Constants {

	enum SCREEN_MODE{
		
	};
	
enum SERVICE_MODE{
		
	};
	
	
	interface Services {

		String BASE_URL = "";
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

		interface ErrorCodeMessage {
			String MISSING_PARAMETER = "Please send proper parameter in order to process request";
			String REQUEST_FAILED = "Request Failed";
			String MISSING_USERNAME_PASSWORD = "Invalid username or password";
		}

	}
	
	interface NoticeCityPreference {
		String PREFERENCE_NAME = "notice_city_pref";
		String PREFERENCE_SELECT_LANG = "language";
		String PREFERENCE_USERNAME = "s_username";
		String PREFERENCE_PASSWORD = "s_password";
		String PREFERENCE_REMEMBER_ME = "s_remember_me";
		String PREFERENCE_REMEMBER_USERNAME = "s_rem_username";
		String PREFERENCE_REMEMBER_PASSWORD = "s_rem_password";
		String PREFERENCE_ID_AFFIALIATE = "s_id_aff";
		String PREFERENCE_ID_SPONSOR = "s_sponsor";
		String PREFERENCE_AUTO_USERNAME = "s_auto_user";
		String PREFERENCE_FIRST_NAME = "s_f_name";
		String PREFERENCE_LAST_NAME = "s_l_name";
		String PREFERENCE_COUNTRY = "s_country";
		String PREFERENCE_USER_SOCIAL_ID = "s_social_id";
		String PREFERENCE_USER_IMAGE = "s_uimage";
		String PREFERENCE_COUPONS = "s_coupons";
		String PREFERENCE_CODE = "s_code";
		String PREFERENCE_COUNTRY_CODE = "s_country_code";
		String PREFERENCE_ID_BRANDING = "s_id_brand";
		String PREFERENCE_WEBSITE = "s_website";
		String PREFERENCE_ID_COUPONS = "s_id_coupons";
		String PREFERENCE_TITLE = "s_title";
		String PREFERENCE_SUB_TITLE = "s_sub_title";
		String PREFERENCE_DETAIL = "s_detail";
		String PREFERENCE_OFFERS = "s_offers";
		String PREFERENCE_SPECIAL_HERE = "s_special_here";
		String PREFERENCE_MY_ID = "s_my_id";
		String PREFERENCE_COUPONS_IMAGE = "s_coupon_img";
	}

	interface RequestCode {
		int CREATE_ACCOUNT = 213;
		int SCAN_ACITIVITY = 214;
	}

	
}
