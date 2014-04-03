package com.throrinstudio.android.common.libs.validator;

import java.util.ArrayList;
import java.util.List;

import android.widget.TextView;

public class Validate extends AbstractValidate {

    private List<AbstractValidator> mValidators = new ArrayList<AbstractValidator>();
    private TextView mSourceView;

    public Validate(TextView sourceView) {
        mSourceView = sourceView;
    }

    /**
     * Add a new validator for fields attached
     *
     * @param validator {@link AbstractValidator} : The validator to attach
     */
    public void addValidator(AbstractValidator validator) {
        mValidators.add(validator);
    }

    public boolean isValid() {
        for (AbstractValidator validator : mValidators) {
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
