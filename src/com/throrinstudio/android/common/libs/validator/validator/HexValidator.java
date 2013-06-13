package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Pattern;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;


public class HexValidator extends AbstractValidator {

    /**
     * This is Hex Pattern to verify value.
     */
    private static final Pattern mPattern = Pattern.compile("^(#|)[0-9A-Fa-f]+$");

    private int mErrorMessage = R.string.validator_alnum;

    public HexValidator(Context c) {
        super(c);
    }

    public HexValidator(Context c, int errorMessage) {
        super(c);
        mErrorMessage = errorMessage;
    }

    @Override
    public boolean isValid(String value) {
        return mPattern.matcher(value).matches();
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
