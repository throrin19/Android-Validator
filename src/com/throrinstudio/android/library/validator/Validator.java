package com.throrinstudio.android.library.validator;

import android.content.Context;

public abstract class Validator {

	protected Context mContext;
	
	public Validator(Context c){
		mContext = c;
	}
	
	public abstract boolean isValid(Object value);
	
	public abstract String getMessage();
}
