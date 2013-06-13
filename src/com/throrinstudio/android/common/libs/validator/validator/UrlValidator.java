package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import android.util.Patterns;
import android.webkit.URLUtil;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

import java.util.regex.Pattern;

public class UrlValidator extends AbstractValidator {

    private static Pattern mPattern = Patterns.WEB_URL;

	private int mErrorMessage = R.string.validator_url;
	
	public UrlValidator(Context c) {
		super(c);
	}
	
	@Override
	public boolean isValid(String url) {
		return mPattern.matcher(url).matches();
	}

	@Override
	public String getMessage() {
		return mContext.getString(mErrorMessage);
	}

}
