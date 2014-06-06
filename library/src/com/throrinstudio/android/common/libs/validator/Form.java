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

	private List<AbstractValidate> mValidates = new ArrayList<AbstractValidate>();

	/**
	 * Function adding Validates to our form
	 * 
	 * @param validate
	 *            {@link AbstractValidate} Validate to add
	 */
	public void addValidates(AbstractValidate validate) {
		mValidates.add(validate);
	}

	/**
	 * Function removing Validates from our form
	 * 
	 * @param validate
	 *            {@link AbstractValidate} Validate to remove
	 * @return validate that was removed from the form
	 */
	public boolean removeValidates(AbstractValidate validate) {
		if (mValidates != null && !mValidates.isEmpty()) {
			return mValidates.remove(validate);
		}
		return false;
	}

	/**
	 * Called to validate our form.
	 * If an error is found, it will be displayed in the corresponding field.
	 * 
	 * @return boolean true if the form is valid, otherwise false
	 */
	public boolean validate() {
		boolean formValid = true;
		for (AbstractValidate validate : mValidates) {
			formValid = formValid & validate.isValid();	// Use & in order to evaluate both side of the operation.
		}
		return formValid;
	}
}
