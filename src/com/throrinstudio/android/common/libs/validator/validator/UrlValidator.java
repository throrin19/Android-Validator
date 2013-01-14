package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import android.webkit.URLUtil;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

public class UrlValidator extends AbstractValidator {
	private int mErrorMessage = R.string.validator_url;
	
	public UrlValidator(Context c) {
		super(c);
	}
	
	@Override
	public boolean isValid(String url) {
		if(url.length() > 0){
			if(URLUtil.isValidUrl(url))
				return true;
			else
				return false;
		}else{
			return true;
		}
	}

	@Override
	public String getMessage() {
		return mContext.getString(mErrorMessage);
	}

}
