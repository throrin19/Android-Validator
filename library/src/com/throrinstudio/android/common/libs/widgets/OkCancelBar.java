package com.throrinstudio.android.common.libs.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.throrinstudio.android.example.validator.R;

/**
 * Represent a bar with 2 buttons
 * @author Castorflex
 *
 */
public class OkCancelBar extends LinearLayout
{
	private Button	okButton;
	private Button	cancelButton;

	public OkCancelBar(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		LayoutInflater.from(context).inflate(R.layout.widget_ok_cancel_bar,
				this, true);

		TypedArray array = context.obtainStyledAttributes(attrs,
				R.styleable.OkCancelBar, 0, 0);

		String text = array.getString(R.styleable.OkCancelBar_okLabel);
		if (text == null)
			text = context.getString(R.string.global_accept);
		okButton = (Button) findViewById(R.id.widget_okcancelbar_ok);
		okButton.setText(text);

		text = array.getString(R.styleable.OkCancelBar_cancelLabel);
		if (text == null)
			text = context.getString(R.string.global_cancel);
		cancelButton = (Button) findViewById(R.id.widget_okcancelbar_cancel);
		cancelButton.setText(text);
	}

	public Button getOkButton()
	{
		return okButton;
	}

	public Button getCancelButton()
	{
		return cancelButton;
	}
}