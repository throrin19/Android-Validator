package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.ValidatorException;
import com.throrinstudio.android.example.validator.R;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: throrin19
 * Date: 31/12/12
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public class RegExpValidator extends AbstractValidator {

    /**
     * This si Alnum Pattern to verify value.
     */
    private Pattern mPattern;

    private int mErrorMessage = R.string.validator_regexp;

    public RegExpValidator(Context c) {
        super(c);
    }

    public void setPattern(String pattern){
        mPattern = Pattern.compile(pattern);
    }

    @Override
    public boolean isValid(Object value) throws ValidatorException {
        if(value != null){
            value = "";
        }

        if(mPattern != null){
            return mPattern.matcher((String)value).matches();
        }else{
            throw new ValidatorException("You can set Regexp Pattern first");
        }
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
