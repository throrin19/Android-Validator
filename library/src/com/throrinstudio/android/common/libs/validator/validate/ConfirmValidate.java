package com.throrinstudio.android.common.libs.validator.validate;

import android.content.Context;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.validator.AbstractValidate;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

public class ConfirmValidate extends AbstractValidate {

	private TextView _field1;
	private TextView _field2;
	private Context mContext;
	private TextView source;
	private int _errorMessage = R.string.validator_confirm;
	
	public ConfirmValidate(TextView field1, TextView field2){
		this._field1 = field1;
		this._field2 = field2;
		source = _field2;
		mContext = field1.getContext();
	}

	@Override
	public boolean isValid(String value) {
		if(_field1.getText().toString().length() > 0 && _field1.getText().toString().equals(_field2.getText().toString())){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public String getMessages() {
		// TODO Auto-generated method stub
		return mContext.getString(_errorMessage);
	}


	@Override
	public void addValidator(AbstractValidator validator) {
	}

	@Override
	public TextView getSource() {
		return source;
	}
	
	
}
