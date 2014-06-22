package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;

/**
 * Validates whether the given value is bettween a range of values
 * 
 * @author Exikle
 */
public class RangeValidator extends AbstractValidator {

	/**
	 * The start of the range
	 */
	final double START_RANGE;

	/**
	 * The end of the range
	 */
	final double END_RANGE;

	/**
	 * The error Id from the string resource
	 */
	private static int mErrorMessage; // Your custom error message

	/**
	 * @param context
	 * @param start
	 *            of the range
	 * @param end
	 *            of the range
	 * @param errorMessageRes
	 */
	public RangeValidator(Context c, double start, double end,
			int errorMessageRes) {
		super(c, errorMessageRes);
		mErrorMessage = errorMessageRes;
		START_RANGE = start;
		END_RANGE = end;
	}

	@Override
	public String getMessage() {
		return getContext().getString(mErrorMessage);
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