package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Pattern;

import android.content.Context;
import android.util.Patterns;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

public class UrlValidator extends AbstractValidator {

    private static Pattern mPattern = Patterns.WEB_URL;

	private int mErrorMessage = R.string.validator_url;

	public UrlValidator(Context c) {
		super(c);
	}

    public UrlValidator(Context c, int errorMessage) {
        super(c);
        mErrorMessage = errorMessage;
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
