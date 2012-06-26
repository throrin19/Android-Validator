package com.throrinstudio.android.library.validator.editText;

import android.content.Context;
import android.webkit.URLUtil;

import com.throrinstudio.android.example.R;
import com.throrinstudio.android.library.validator.Validator;

public class UrlValidator extends Validator {

	private int mErrorMessage = R.string.validator_url;
	
	public UrlValidator(Context c) {
		super(c);
	}
	
	@Override
	public boolean isValid(Object value) {
		String url = ((CharSequence)value).toString();
		if(url.length() > 0){
			if(URLUtil.isHttpUrl(url) && URLUtil.isValidUrl(url))
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
