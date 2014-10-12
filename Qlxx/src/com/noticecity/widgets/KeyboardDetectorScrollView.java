package com.noticecity.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

public class KeyboardDetectorScrollView extends ScrollView {

	private static final String TAG = KeyboardDetectorScrollView.class
			.getSimpleName();
	private SoftKeyboardListener softKeyboardListener;
	private int deviationFactor = 0;

	public KeyboardDetectorScrollView(Context context) {
		super(context);
	}

	public KeyboardDetectorScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		final int proposedheight = MeasureSpec.getSize(heightMeasureSpec);
		final int actualHeight = getHeight();

		int delta = actualHeight - proposedheight;
		int offset = actualHeight / 4; // if 1/4 of screen is cut off, we assume
										// the keyboard is visible
		if (delta > offset) {
			Log.d(TAG, "keyboard is visible");
			if (softKeyboardListener != null)
				softKeyboardListener.onSoftKeyboardShow();
		} else {
			Log.d(TAG, "keyboard is not visible");
			if (softKeyboardListener != null)
				softKeyboardListener.onSoftKeyboardHide();
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	public void setSoftKeyboardListener(
			SoftKeyboardListener softKeyboardListener) {
		this.softKeyboardListener = softKeyboardListener;
	}

	// @Override
	// protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	// final int proposedheight =
	// MeasureSpec.getSize(heightMeasureSpec)-deviationFactor;
	// final int actualHeight = getHeight();
	//
	// int delta = actualHeight - proposedheight;
	// int offset = actualHeight / 4-(deviationFactor/4); // if 1/4 of screen is
	// cut off, we assume
	// // the keyboard is visible
	// if (delta > offset) {
	// Log.d(TAG, "keyboard is visible");
	// if (softKeyboardListener != null)
	// softKeyboardListener.onSoftKeyboardShow();
	// } else {
	// Log.d(TAG, "keyboard is not visible");
	// if (softKeyboardListener != null)
	// softKeyboardListener.onSoftKeyboardHide();
	// }
	// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	// }

	public static interface SoftKeyboardListener {
		public void onSoftKeyboardShow();

		public void onSoftKeyboardHide();
	}

	public int getDeviationFactor() {
		return deviationFactor;
	}

	public void setDeviationFactor(int deviationFactor) {
		this.deviationFactor = deviationFactor;
	}

}
