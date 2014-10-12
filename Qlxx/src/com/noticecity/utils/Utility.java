/**
 * Project : FIFA
 * Author : ashutosh
 * Creation Date : Mar 27, 2014
 * Description : @TODO
 */
package com.noticecity.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.client.Response;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Utility {
	private static final String TAG = Utility.class.getSimpleName();

	public static void hideSoftKeyboard(Activity activity, View myEditText) {
		if (myEditText != null) {
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(myEditText.getApplicationWindowToken(), 0);
		}
	}

	public static void showSoftKeyboard(Activity activity, View myEditText) {
		if (myEditText != null) {
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(myEditText, 0);
		}
	}

	/**
	 * Description : Custom Message
	 */
	public static boolean isNotEmptyError(Activity activity, EditText editText, String msg) {
		if (editText.getText().toString().trim().equalsIgnoreCase("")) {
			editText.requestFocus();
			editText.setError(msg);
			return false;
		} else {
			return true;
		}
	}

	public static boolean isNotEmptyError(Activity activity, EditText editText, String msg, String limitMsg, int minLimit) {
		if (editText.getText().toString().trim().equalsIgnoreCase("")) {
			editText.requestFocus();
			editText.setError(msg);
			return false;
		} else {
			int length = editText.getText().toString().trim().length();
			if (length >= minLimit)
				return true;
			else {
				editText.requestFocus();
				editText.setError(limitMsg + " must be atleast " + minLimit + " character long");
				return false;
			}
		}
	}

	/**
	 * Description : Custom Message
	 */
	public static boolean isNotEmpty(Activity activity, EditText editText, String msg) {
		if (editText.getText().toString().trim().equalsIgnoreCase("")) {
			ShowToast(activity, msg);
			return false;
		} else {
			return true;
		}
	}

	public static boolean isNotEmpty(Activity activity, TextView editText, String msg) {
		if (editText.getText().toString().trim().equalsIgnoreCase("")) {
			ShowToast(activity, msg);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Description : Default Message
	 */
	public static boolean isNotEmptyDefault(Activity activity, EditText editText, String field) {
		return isNotEmpty(activity, editText, field + " " + Constants.ToastMesaage.FIELD_CANT_BLANK);
	}

	public static boolean validateEmail(Activity activity, EditText editText) {
		Pattern pattern;
		Matcher matcher;
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(editText.getText().toString());
		if (matcher.matches()) {
			return true;
		} else {
			ShowToast(activity, Constants.ToastMesaage.INVALID_EMAIL);
			return false;
		}
	}

	public static boolean validateEmailDropBox(Activity activity, EditText editText) {
		Pattern pattern;
		Matcher matcher;
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(editText.getText().toString());
		if (matcher.matches()) {
			return true;
		} else {
			editText.requestFocus();
			editText.setError(Constants.ToastMesaage.INVALID_EMAIL);
			return false;
		}
	}

	public static boolean validateEmailDropBox(Activity activity, EditText editText, String text) {
		Pattern pattern;
		Matcher matcher;
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return true;
		} else {
			editText.requestFocus();
			editText.setError(Constants.ToastMesaage.INVALID_EMAIL);
			return false;
		}
	}

	public static String ByteArrayTobase64(ByteArrayOutputStream byteArrayOutputStream) {
		if (byteArrayOutputStream == null) {
			return "";
		}
		try {
			byte[] ba = byteArrayOutputStream.toByteArray();
			int flag = 0;
			String ba1 = Base64.encodeToString(ba, flag);
			return ba1;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "";
	}

	/**
	 * Description : Message String
	 */
	public static void ShowToast(final Activity activity, final String msg) {
		if (msg != null && !msg.trim().equalsIgnoreCase("")) {
			activity.runOnUiThread(new Runnable() {

				@Override
				public void run() {

					Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
				}

			});
		}
	}

	public static void setVisiblity(View view, boolean isVisible) {
		if (view != null) {
			if (isVisible) {
				view.setVisibility(View.VISIBLE);
			} else {
				view.setVisibility(View.GONE);
			}
		}
	}

	public static void doInvisible(View view, boolean isInVisible) {
		if (view != null) {
			if (isInVisible) {
				view.setVisibility(View.INVISIBLE);
			} else {
				view.setVisibility(View.VISIBLE);
			}
		}
	}

	public static Bundle insertValueBundleFragment(FragmentActivity activity, String key, Serializable serializable) {
		Bundle bundle = activity.getIntent().getExtras();
		if (bundle == null) {
			bundle = new Bundle();
		}
		bundle.putSerializable(key, serializable);
		return bundle;
	}

	public static Bundle insertValueInBundle(Bundle bundle, String key, Serializable serializable) {
		if (bundle == null) {
			bundle = new Bundle();
		}
		bundle.putSerializable(key, serializable);
		return bundle;
	}

	public static Serializable getValueBundleFragment(FragmentActivity activity, String key) {
		Bundle bundle = activity.getIntent().getExtras();
		if (bundle == null) {
			bundle = new Bundle();
		}
		Serializable serializable = bundle.getSerializable(key);
		return serializable;
	}

	public static void saveBundleFragment(FragmentActivity activity, Bundle bundle) {
		activity.getIntent().putExtras(bundle);
	}

	public static int getInt(String answer) {

		try {
			int parseInt = Integer.parseInt(answer);
			return parseInt;
		} catch (ClassCastException classCastException) {
			classCastException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getInt(String answer, int i) {
		try {
			int parseInt = Integer.parseInt(answer);
			return parseInt;
		} catch (ClassCastException classCastException) {
			classCastException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// public static String getResponse(Response response)
	// {
	// try
	// {
	// Gson gson = new GsonBuilder().setPrettyPrinting().create();
	// JsonParser jp = new JsonParser();
	// JsonElement je =
	// jp.parse(convertStreamToString(response.getBody().in()));
	// return gson.toJson(je);
	// }
	// catch (IOException e)
	// {
	// e.printStackTrace();
	// return "";
	// }
	// catch (JsonSyntaxException e)
	// {
	// e.printStackTrace();
	// try
	// {
	// return convertStreamToString(response.getBody().in());
	// }
	// catch (IOException e1)
	// {
	// e1.printStackTrace();
	// return "";
	// }
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// return "";
	// }
	// }
	//
	// public static String convertStreamToString(InputStream is)
	// {
	// BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	// StringBuilder sb = new StringBuilder();
	// String line = null;
	// try
	// {
	// while ((line = reader.readLine()) != null)
	// {
	// sb.append(line + "\n");
	// }
	// }
	// catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	// finally
	// {
	// try
	// {
	// is.close();
	// }
	// catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	// }
	// return sb.toString();
	// }

	public static String getResponse(Response response) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonParser jp = new JsonParser();
			JsonElement je = jp.parse(convertStreamToString(response.getBody().in()));
			return gson.toJson(je);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (JsonSyntaxException e) {
			try {
				return convertStreamToString(response.getBody().in());
			} catch (IOException e1) {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
		} finally {
			try {
				is.close();
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}

	@SuppressWarnings("deprecation")
	public static int[] getScreenDimension(Activity activity) {
		int height = activity.getWindow().getWindowManager().getDefaultDisplay().getHeight();
		int width = activity.getWindow().getWindowManager().getDefaultDisplay().getWidth();
		return new int[] { width, height };
	}

	// "yyyyy.MMMMM.dd GGG hh:mm aaa"
	public static String getDateInFormat(long mills) {
		Log.d(TAG, "mills: " + mills);
		String pattern = "hh:mm aaa, MMMMM dd yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(mills);
		String format = simpleDateFormat.format(date);
		return format;

	}

	public static String getDateInFormat(long mills, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(mills);
		simpleDateFormat.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		String format = simpleDateFormat.format(date);
		return format;

	}

	public static String getDate(String dateStr, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		// simpleDateFormat.setTimeZone(new
		// SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		Date date = new Date(dateStr);
		String format = simpleDateFormat.format(date);
		return format;

	}

	public static String getTime(String dateStr, String pattern) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = formatter.parse(dateStr);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
			String format = simpleDateFormat.format(date);
			return format;
		} catch (IllegalArgumentException illegalArgumentException) {
			illegalArgumentException.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static long getTimeInMills(String dateStr, String pattern) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date;
			date = formatter.parse(dateStr);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static String getRealPathFromURI(String contentURI, Activity act) {
		Uri contentUri = Uri.parse(contentURI);
		Cursor cursor = act.getContentResolver().query(contentUri, null, null, null, null);
		if (cursor == null) {
			return contentUri.getPath();
		} else {
			cursor.moveToFirst();
			int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
			return cursor.getString(index);
		}
	}

	public static Bitmap compressImage(String imageUri, Activity act) {

		try {
			String filePath = getRealPathFromURI(imageUri, act);
			Bitmap scaledBitmap = null;

			BitmapFactory.Options options = new BitmapFactory.Options();

			// by setting this field as true, the actual bitmap pixels are not
			// loaded in the memory. Just the bounds are loaded. If
			// you try the use the bitmap here, you will get null.
			options.inJustDecodeBounds = true;
			Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

			int actualHeight = options.outHeight;
			int actualWidth = options.outWidth;

			// max Height and width values of the compressed image is taken as
			// 816x612

			float maxHeight = 816.0f;
			float maxWidth = 612.0f;
			float imgRatio = actualWidth / actualHeight;
			float maxRatio = maxWidth / maxHeight;

			// width and height values are set maintaining the aspect ratio of
			// the
			// image

			if (actualHeight > maxHeight || actualWidth > maxWidth) {
				if (imgRatio < maxRatio) {
					imgRatio = maxHeight / actualHeight;
					actualWidth = (int) (imgRatio * actualWidth);
					actualHeight = (int) maxHeight;
				} else if (imgRatio > maxRatio) {
					imgRatio = maxWidth / actualWidth;
					actualHeight = (int) (imgRatio * actualHeight);
					actualWidth = (int) maxWidth;
				} else {
					actualHeight = (int) maxHeight;
					actualWidth = (int) maxWidth;

				}
			}

			// setting inSampleSize value allows to load a scaled down version
			// of
			// the original image

			options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

			// inJustDecodeBounds set to false to load the actual bitmap
			options.inJustDecodeBounds = false;

			// this options allow android to claim the bitmap memory if it runs
			// low
			// on memory
			options.inPurgeable = true;
			options.inInputShareable = true;
			options.inTempStorage = new byte[16 * 1024];

			try {
				// load the bitmap from its path
				bmp = BitmapFactory.decodeFile(filePath, options);
			} catch (OutOfMemoryError exception) {
				exception.printStackTrace();

			}
			try {
				scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
			} catch (OutOfMemoryError exception) {
				exception.printStackTrace();
			}

			float ratioX = actualWidth / (float) options.outWidth;
			float ratioY = actualHeight / (float) options.outHeight;
			float middleX = actualWidth / 2.0f;
			float middleY = actualHeight / 2.0f;

			Matrix scaleMatrix = new Matrix();
			scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

			Canvas canvas = new Canvas(scaledBitmap);
			canvas.setMatrix(scaleMatrix);
			canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

			// check the rotation of the image and display it properly
			ExifInterface exif;
			try {
				exif = new ExifInterface(filePath);

				int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
				Log.d("EXIF", "Exif: " + orientation);
				Matrix matrix = new Matrix();
				if (orientation == 6) {
					matrix.postRotate(90);
					Log.d("EXIF", "Exif: " + orientation);
				} else if (orientation == 3) {
					matrix.postRotate(180);
					Log.d("EXIF", "Exif: " + orientation);
				} else if (orientation == 8) {
					matrix.postRotate(270);
					Log.d("EXIF", "Exif: " + orientation);
				}
				scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
			} catch (IOException e) {
				e.printStackTrace();
			}

			FileOutputStream out = null;
			String filename = getFilename();
			try {
				out = new FileOutputStream(filename);

				// write the compressed bitmap at the destination specified by
				// filename.
				scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return scaledBitmap;
		} catch (ArithmeticException arithmeticException) {
			arithmeticException.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getFilename() {
		File file = new File(Environment.getExternalStorageDirectory().getPath(), "MyFolder/Images");
		if (!file.exists()) {
			file.mkdirs();
		}
		String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
		return uriSting;

	}

	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	public String getRealPathFromURI(Uri contentURI, Context con) {
		String result;
		Cursor cursor = con.getContentResolver().query(contentURI, null, null, null, null);
		if (cursor == null) { // Source is Dropbox or other similar local file
								// path
			result = contentURI.getPath();
		} else {
			cursor.moveToFirst();
			int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
			result = cursor.getString(idx);
			cursor.close();
		}
		return result;
	}

	public static Bitmap getOrientationFromExif(Bitmap bitmap, int orientation) {
		try {
			int width = bitmap.getWidth();
			int height = bitmap.getHeight();
			int newWidth = 612;
			int newHeight = 816;

			// calculate the scale - in this case = 0.4f
			float scaleWidth = ((float) newWidth) / width;
			float scaleHeight = ((float) newHeight) / height;
			Matrix matrix = new Matrix();
			switch (orientation) {
			case ExifInterface.ORIENTATION_NORMAL:
				return bitmap;
			case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
				// matrix.setScale(-1, 1);
				matrix.postScale(scaleWidth, scaleHeight);
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				matrix.setRotate(180);
				break;
			case ExifInterface.ORIENTATION_FLIP_VERTICAL:
				matrix.setRotate(180);
				// matrix.postScale(-1, 1);
				matrix.postScale(scaleWidth, scaleHeight);
				break;
			case ExifInterface.ORIENTATION_TRANSPOSE:
				matrix.setRotate(90);
				// matrix.postScale(-1, 1);
				matrix.postScale(scaleWidth, scaleHeight);
				break;
			case ExifInterface.ORIENTATION_ROTATE_90:
				matrix.setRotate(90);
				break;
			case ExifInterface.ORIENTATION_TRANSVERSE:
				matrix.setRotate(-90);
				// matrix.postScale(-1, 1);
				matrix.postScale(scaleWidth, scaleHeight);
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				matrix.setRotate(-90);
				break;
			default:
				return bitmap;
			}
			Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
			bitmap.recycle();
			return bmRotated;
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isNotEmptyDrop(FragmentActivity activity, EditText gNameView, String groupNameBlank) {
		if (gNameView == null)
			return false;
		boolean isEmpty = gNameView.getText().toString().trim().length() > 0 ? true : false;
		if (!isEmpty) {
			Log.d(TAG, "error is " + groupNameBlank);
			gNameView.setError(groupNameBlank);
			gNameView.requestFocus();
		}
		return isEmpty;
	}

	public static double getDouble(String text) {
		int size = text == null ? 0 : text.trim().length();
		try {
			if (size > 0) {
				Double valueOf = Double.valueOf(text);
				return valueOf;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0.0;

	}

	public static String getDealsTimeLeft(long startDate) {
		long currentTimeMillis = System.currentTimeMillis();
		if (startDate > currentTimeMillis) {
			long remHour = startDate - (currentTimeMillis);
			remHour = remHour / 1000;
			long sec = remHour % 60;
			remHour /= 60;
			long minutes = remHour % 60;
			remHour /= 60;
			long hour = remHour % 24;
			remHour /= 24;
			long days = remHour;

			if (days <= 0 && remHour <= 0) {
				return "0 days Left";
			} else {
				String str = "";
				str = sec <= 0 ? str : sec + " sec left";
				str = minutes <= 0 ? str : minutes + " minutes left";
				str = hour <= 0 ? str : hour + " hr left";

				str = days >= 1 ? days + " days left" : str;
				return str;

			}
		}
		return "0 days left";
	}

	public static void getAppKeyHash(Activity activity) {
		try {
			PackageInfo info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md;

				md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				String something = new String(Base64.encode(md.digest(), 0));
				Log.d("Hash key: ", something);
			}
		} catch (NameNotFoundException e1) {
			Log.e("name not found", e1.toString());
		}

		catch (NoSuchAlgorithmException e) {
			Log.e("no such an algorithm", e.toString());
		} catch (Exception e) {
			Log.e("exception", e.toString());
		}

	}

	public static boolean isListEmpty(List<?> list) {
		int size = list == null ? 0 : list.size();
		if (size > 0) {
			return false;
		}
		return true;
	}

	public static boolean isSetEmpty(Set<?> list) {
		int size = list == null ? 0 : list.size();
		if (size > 0) {
			return false;
		}
		return true;
	}

	

	public static int dpToPixel(Activity activity, int dp) {
		Resources resources = activity.getResources();
		float applyDimension = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
		return (int) applyDimension;
	}

	/**
	 * @param activity
	 * @param dimension
	 * @return
	 */
	public static int dpToPixel(Activity activity, float dimension) {
		Resources resources = activity.getResources();
		float applyDimension = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dimension, resources.getDisplayMetrics());
		return (int) applyDimension;
	}

	

	public static String getCountryCode(String item) {

		if (item.equalsIgnoreCase("United States"))
			return "us";
		if (item.equalsIgnoreCase("United Kingdom"))
			return "uk";

		if (item.equalsIgnoreCase("Sweden"))
			return "sv";

		if (item.equalsIgnoreCase("Italy"))
			return "it";

		if (item.equalsIgnoreCase("Russia"))
			return "ru";
		return "";

	}

	public static Intent getEmailIntent(Activity activity, String subject, String body) {
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_SUBJECT, subject);
		email.putExtra(Intent.EXTRA_TEXT, body);
		email.setType("message/rfc822");
		return email;
	}

	public static Intent getMessageIntent(Activity activity, String message, String phoneNumber) {

		/*
		 * Intent msgIntent = new Intent(Intent.ACTION_VIEW); Log.d(TAG,
		 * "phone number selected: " + phoneNumber);
		 * msgIntent.setData(Uri.parse("sms:" + phoneNumber + ""));
		 * msgIntent.putExtra("sms_body", message);
		 * msgIntent.putExtra("address", phoneNumber);
		 * msgIntent.putExtra("exit_on_sent", true);
		 * msgIntent.setType("vnd.android-dir/mms-sms"); return msgIntent;
		 */

		Log.d(TAG, "phone number selected: " + phoneNumber);

		Uri uri = Uri.parse("smsto:" + phoneNumber);
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.putExtra("sms_body", message);
		intent.putExtra("exit_on_sent", true);

		return intent;

	}

	public static String getBlipDealCountry(String myCountry) {
		if (myCountry.equalsIgnoreCase("United States")) {
			return "UNITED_STATES";
		}

		if (myCountry.equalsIgnoreCase("United Kingdom")) {
			return "UNITED_KINGDOM";
		}

		if (myCountry.equalsIgnoreCase("Sweden")) {
			return myCountry;
		}

		if (myCountry.equalsIgnoreCase("Russia")) {
			return "RUSSIA";
		}

		if (myCountry.equalsIgnoreCase("Italy")) {
			return "ITALY";
		}
		return myCountry;

	}

	public static boolean isOnline(Activity activity) {
		ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		// ShowToast("No Internet Connection");
		return false;
	}

	public static String dateFormat(String pattern, Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String format = simpleDateFormat.format(date);
		return format;
	}

	public static void setLanguage(Activity activity, String item) {
		String countryCode = Utility.getCountryCode(item);

		Resources res = activity.getResources();
		// Change locale settings in the app.
		DisplayMetrics dm = res.getDisplayMetrics();
		android.content.res.Configuration conf = res.getConfiguration();
		conf.locale = new Locale(countryCode);
		res.updateConfiguration(conf, dm);
	}

	
}
