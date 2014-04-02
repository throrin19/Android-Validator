package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import android.text.TextUtils;

import com.throrinstudio.android.common.libs.validator.BaseValidator;
import com.throrinstudio.android.example.validator.R;

public class NotEmptyValidator extends BaseValidator {

    private static final int DEFAULT_ERROR_MESSAGE_RESOURCE = R.string.validator_empty;

    public NotEmptyValidator(Context c) {
        super(c, DEFAULT_ERROR_MESSAGE_RESOURCE);
    }

    public NotEmptyValidator(Context c, int errorMessage) {
        super(c, DEFAULT_ERROR_MESSAGE_RESOURCE);
    }

    @Override
    public boolean isValid(String text) {
        return !TextUtils.isEmpty(text);
    }
}
