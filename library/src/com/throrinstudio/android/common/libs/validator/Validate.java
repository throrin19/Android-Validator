package com.throrinstudio.android.common.libs.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.widget.TextView;

public class Validate extends BaseValidate {

    private List<BaseValidator> mValidators = new ArrayList<BaseValidator>();
    private TextView mSourceView;

    public Validate(TextView sourceView) {
        mSourceView = sourceView;
    }

    /**
     * Add a new validator for fields attached
     *
     * @param validator {@link BaseValidator} : The validator to attach
     */
    public void addValidator(BaseValidator validator) {
        mValidators.add(validator);
    }

    public boolean isValid() {
        Iterator<BaseValidator> it = mValidators.iterator();
        while (it.hasNext()) {
            BaseValidator validator = it.next();
            try {
                if (!validator.isValid(mSourceView.getText().toString())) {
                    mSourceView.setError(validator.getMessage());
                    return false;
                }
            } catch (ValidatorException e) {
                e.printStackTrace();
                mSourceView.setError(e.getMessage());
                return false;
            }
        }
        mSourceView.setError(null);
        return true;
    }

    public TextView getSource() {
        return mSourceView;
    }

}
