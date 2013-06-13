package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import android.util.Patterns;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.ValidatorException;
import com.throrinstudio.android.example.validator.R;

import java.util.regex.Pattern;

/**
 * Validator to check if Phone number is correct.
 * Created by throrin19 on 13/06/13.
 */
public class PhoneValidator extends AbstractValidator{

    private static final Pattern mPattern = Patterns.PHONE;

    private int mErrorMessage = R.string.validator_phone;

    public PhoneValidator(Context c) {
        super(c);
    }

    @Override
    public boolean isValid(String value) throws ValidatorException {
        return mPattern.matcher(value).matches();
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
