package com.throrinstudio.android.library.validator;

import java.util.ArrayList;
import java.util.Iterator;

import android.widget.TextView;

/**
 * Classe de validation de formulaire
 * 
 * TODO à optimiser pour gérer les checkBox et les radioButtons, 
 * tout de suite, ne marche qu'avec les EditText
 * 
 * @author WEB
 * 
 * @version 0.1
 *
 */
public class Form {

	protected ArrayList<AbstractValidate> _validates = new ArrayList<AbstractValidate>();
	
	public void addValidates(AbstractValidate validate){
		this._validates.add(validate);
		return;
	}
	
	public boolean validate(){
		boolean result = true;
		Iterator<AbstractValidate> it = this._validates.iterator();
		while(it.hasNext()){
			AbstractValidate validator = it.next();
			TextView field = validator.getSource();
			field.setError(null);
			if(!validator.isValid(field.getText())){
				result = false;
				field.setError(validator.getMessages());
			}
		}
		return result;
	}
}
