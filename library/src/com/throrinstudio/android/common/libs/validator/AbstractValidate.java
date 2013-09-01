package com.throrinstudio.android.common.libs.validator;

import android.widget.TextView;

public abstract class AbstractValidate {

	/**
	 * Add a new validator for fields attached
	 * @param validator
	 * 		{@link AbstractValidator} : The validator to attach
	 */
	public abstract void addValidator(AbstractValidator validator);
	
	/**
	 * Function called when the {@link Form} validation
	 * @param value
	 * 		{@link String} : value to validate
	 * @return
	 * 		true if all validators are valid
     *      false if a validator is invalid
	 */
	public abstract boolean isValid(String value);
	
	/**
	 * Returns the error message displayed on the connected component
	 * @return
	 * 		{@link String} : the message to display
	 */
	public abstract String getMessages();
	
	/**
	 * Function recovering the field attached to our validator
	 * @return
	 * 		{@link TextView} : The fields attached
	 */
	public abstract TextView getSource();
}
