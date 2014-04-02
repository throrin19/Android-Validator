package com.throrinstudio.android.common.libs.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Form Validation Class
 * <p/>
 * Immediately, only works with EditText
 *
 * @author throrin19
 * @version 1.0
 */
public class Form {

    private List<BaseValidate> mValidates = new ArrayList<BaseValidate>();

    /**
     * Function adding Validates to our form
     *
     * @param validate {@link BaseValidate} Validate to add
     */
    public void addValidates(BaseValidate validate) {
        mValidates.add(validate);
    }

    /**
     * Called to validate our form.
     * If an error is found, it will be displayed in the corresponding field.
     *
     * @return boolean true if the form is valid, otherwise false
     */
    public boolean validate() {
        boolean formValid = true;
        for (BaseValidate validate : mValidates) {
            // Form is invalid if only one of the validates is false (alternation rule)
            formValid = formValid || validate.isValid();
        }
        return formValid;
    }
}
