package com.throrinstudio.android.library.validator;

import android.widget.TextView;

public abstract class AbstractValidate {

	public abstract void addValidator(Validator validator);
	
	public abstract boolean isValid(Object value);
	
	public abstract String getMessages();
	
	public abstract TextView getSource();
}
