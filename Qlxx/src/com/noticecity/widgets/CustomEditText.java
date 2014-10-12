/**
 * Project : FIFA
 * Author : ashutosh
 * Creation Date : Mar 27, 2014
 * Description : @TODO
 */
package com.noticecity.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class CustomEditText extends EditText
{
	public CustomEditText(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		int size = attrs == null ? 0 : attrs.getAttributeCount();
		for (int i = 0; i < size; i++)
		{
			String attributeValue = attrs.getAttributeValue("http://schemas.android.com/apk/res/com.noticecity", "ttf_name");
			init(context, attributeValue);
		}

	}

	private void init(Context mContext, String ttfName)
	{
		Typeface font = Typeface.createFromAsset(mContext.getAssets(), ttfName);
		setTypeface(font);
	}

	@Override
	public void setTypeface(Typeface tf)
	{
		super.setTypeface(tf);
	}

}
