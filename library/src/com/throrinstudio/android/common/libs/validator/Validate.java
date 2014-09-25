package com.throrinstudio.android.common.libs.validator;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
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
                    setSourceViewError(validator.getMessage(), validator.getErrorDrawable());
                    return false;
                }
            } catch (ValidatorException e) {
                e.printStackTrace();
                setSourceViewError(e.getMessage(), validator.getErrorDrawable());
                return false;
            }
        }
        mSourceView.setError(null);
        return true;
    }

    public TextView getSource() {
        return mSourceView;
    }

  /**
   * Sets error on {@link #mSourceView}.
   *
   * @param errorMessage  String : the error message
   * @param errorDrawable Drawable : the drawable to display
   */
    private void setSourceViewError(String errorMessage, Drawable errorDrawable) {
        if(errorDrawable != null) {
          mSourceView.setError(errorMessage, errorDrawable);
        } else {
          mSourceView.setError(errorMessage);
        }
    }
}
