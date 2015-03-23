package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.R;

public class EmailValidator extends AbstractValidator {

    private static final int DEFAULT_ERROR_MESSAGE_RESOURCE = R.string.validator_email;
    private String mDomainName = "";

    public EmailValidator(Context c) {
        super(c, DEFAULT_ERROR_MESSAGE_RESOURCE);
    }

    public EmailValidator(Context c, int errorMessageRes) {
        super(c, errorMessageRes);
    }

    public EmailValidator(Context c, int errorMessageRes, Drawable errorDrawable) {
        super(c, errorMessageRes, errorDrawable);
    }

    /**
     * Lets say that the email address must be valid for such domain.
     * This function only accepts strings of Regexp
     *
     * @param domainName Regexp Domain Name
     *                   <p/>
     *                   example : gmail.com
     */
    public void setDomainName(String domainName) {
        mDomainName = domainName;
    }

    @Override
    public boolean isValid(String email) {
        if (isNotEmpty(email)) {
            if (isNotEmpty(mDomainName)) {
                Pattern pattern = Pattern.compile(".+@" + mDomainName);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            } else {
                Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }
        }
        return false;
    }

    private boolean isNotEmpty(String text) {
        return !TextUtils.isEmpty(text);
    }
}
