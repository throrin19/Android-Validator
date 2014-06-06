package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;

public class RangeValidator extends AbstractValidator {

	final double START_RANGE;

	final double END_RANGE;

	private static int mErrorMessage; // Your custom error message

	public RangeValidator(Context c, double start, double end,
			int errorMessageRes) {
		super(c, errorMessageRes);
		mErrorMessage = errorMessageRes;
		START_RANGE = start;
		END_RANGE = end;
	}

	@Override
	public String getMessage() {
		return mContext.getString(mErrorMessage);
	}

	@Override
	public boolean isValid(String value) {
		if (value != null) {
			if (value.length() > 0) {
				double inputedSize = Double.parseDouble(value);
				if (inputedSize >= START_RANGE
						&& inputedSize <= END_RANGE)
					return true;
				else
					return false;
			} else
				return false;
		} else
			return false;
	}
}