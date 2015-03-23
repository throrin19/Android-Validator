package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Patterns;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.R;

public class UrlValidator extends AbstractValidator {

    private static final Pattern WEB_URL_PATTERN = Patterns.WEB_URL;
    private static final int DEFAULT_ERROR_MESSAGE_RESOURCE = R.string.validator_url;

    public UrlValidator(Context c) {
        super(c, DEFAULT_ERROR_MESSAGE_RESOURCE);
    }

    public UrlValidator(Context c, int errorMessageRes) {
        super(c, errorMessageRes);
    }

    public UrlValidator(Context c, int errorMessageRes, Drawable errorDrawable) {
        super(c, errorMessageRes, errorDrawable);
    }

    @Override
    public boolean isValid(String url) {
        return WEB_URL_PATTERN.matcher(url).matches();
    }
}
