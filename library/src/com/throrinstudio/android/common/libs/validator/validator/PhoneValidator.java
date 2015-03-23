package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Patterns;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.ValidatorException;
import com.throrinstudio.android.common.libs.validator.R;

/**
 * Validator to check if Phone number is correct.
 * Created by throrin19 on 13/06/13.
 */
public class PhoneValidator extends AbstractValidator {

    private static final Pattern PHONE_PATTERN = Patterns.PHONE;
    private static final int DEFAULT_ERROR_MESSAGE_RESOURCE = R.string.validator_phone;

    public PhoneValidator(Context c) {
        super(c, DEFAULT_ERROR_MESSAGE_RESOURCE);
    }

    public PhoneValidator(Context c, int errorMessageRes) {
        super(c, errorMessageRes);
    }

    public PhoneValidator(Context c, int errorMessageRes, Drawable errorDrawable) {
        super(c, errorMessageRes, errorDrawable);
    }

    @Override
    public boolean isValid(String phone) throws ValidatorException {
        return PHONE_PATTERN.matcher(phone).matches();
    }
}
