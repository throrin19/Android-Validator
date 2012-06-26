package com.throrinstudio.android.library.validator.editText;

import android.content.Context;
import com.throrinstudio.android.example.R;
import com.throrinstudio.android.library.validator.Validator;

public class NotEmptyValidator extends Validator {
	
	private int mErrorMessage = R.string.validator_empty;
	
	
	public NotEmptyValidator(Context c) {
		super(c);
	}
	
	@Override
	public boolean isValid(Object value) {
		if(value != null){
			CharSequence test = (CharSequence)value;
			if(test.length() > 0)
				return true;
			else
				return false;
		}else{
			return false;
		}
	}

	@Override
	public String getMessage() {
		return mContext.getString(mErrorMessage);
	}

}
