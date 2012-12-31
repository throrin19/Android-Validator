package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: throrin19
 * Date: 31/12/12
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class HexValidator extends AbstractValidator {

    /**
     * This is Hex Pattern to verify value.
     */
    private static final Pattern mPattern = Pattern.compile("^(#|)[0-9A-Fa-f]+$");

    private int mErrorMessage = R.string.validator_alnum;

    public HexValidator(Context c) {
        super(c);
    }

    @Override
    public boolean isValid(Object value) {
        if(value != null){
            value = "";
        }

        return mPattern.matcher((String)value).matches();
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
