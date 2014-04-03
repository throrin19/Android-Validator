package com.throrinstudio.android.common.libs.validator.validate;

import android.content.Context;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.validator.AbstractValidate;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;

/**
 * Validator class to validate if the fields are empty fields of 2 or not.
 * If one of them is null, no error.
 * If both are nulls: Error
 *
 * @author throrin19
 */
public class OrTwoRequiredValidate extends AbstractValidate {

    private TextView mFirstField;
    private TextView mSecondField;
    private Context mContext;

    public OrTwoRequiredValidate(TextView field1, TextView field2) {
        mFirstField = field1;
        mSecondField = field2;
        mContext = mFirstField.getContext();
    }

    @Override
    public boolean isValid() {
        Validate firstFieldValidator = new Validate(mFirstField);
        NotEmptyValidator notEmptyValidator = new NotEmptyValidator(mContext);
        firstFieldValidator.addValidator(notEmptyValidator);

        Validate secondFieldValidator = new Validate(mSecondField);
        secondFieldValidator.addValidator(notEmptyValidator);

        if (firstFieldValidator.isValid() || secondFieldValidator.isValid()) {
            mFirstField.setError(null);
            return true;
        } else {
            mFirstField.setError(notEmptyValidator.getMessage());
            return false;
        }
    }
}
