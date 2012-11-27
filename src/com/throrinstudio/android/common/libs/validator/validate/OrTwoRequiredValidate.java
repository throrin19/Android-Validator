package com.throrinstudio.android.common.libs.validator.validate;

import android.content.Context;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.validator.AbstractValidate;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;

/**
 * Classe validator permettant de valider si les champs 
 * de 2 fields sont empty ou pas.
 * Si l'un des deux est null, pas d'erreur.
 * Si les deux sont nulls : erreur
 * @author WEB
 *
 */
public class OrTwoRequiredValidate extends AbstractValidate {

	private TextView _field1;
	private TextView _field2;
	private Context mContext;
	
	public OrTwoRequiredValidate(TextView field1, TextView field2){
		this._field1 = field1;
		this._field2 = field2;
		source = _field1;
		mContext = field1.getContext();
	}
	
	private TextView source;
	
	private String _errorMessage;

	@Override
	public boolean isValid(Object value) {
		//ici la value, on s'en tape
		Validate field1Validator = new Validate(_field1);
		field1Validator.addValidator(new NotEmptyValidator(mContext));
		
		Validate field2Validator = new Validate(_field2);
		field2Validator.addValidator(new NotEmptyValidator(mContext));
		
		if(field1Validator.isValid(_field1.getText()) || field2Validator.isValid(_field2.getText())){
			return true;
		}else{
			_errorMessage = field1Validator.getMessages();
			return false;
		}
	}


	@Override
	public String getMessages() {
		// TODO Auto-generated method stub
		return _errorMessage;
	}


	@Override
	public void addValidator(AbstractValidator validator) {
	}

	@Override
	public TextView getSource() {
		return source;
	}
	
	
}
