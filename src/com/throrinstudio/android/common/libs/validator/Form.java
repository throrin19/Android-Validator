package com.throrinstudio.android.common.libs.validator;

import java.util.ArrayList;
import java.util.Iterator;

import android.widget.TextView;

/**
 * Classe de validation de formulaire
 * 
 * TODO à optimiser pour gérer les checkBox et les radioButtons, 
 * tout de suite, ne marche qu'avec les EditText
 * 
 * @author throrin19
 * 
 * @version 1.0
 *
 */
public class Form {

	protected ArrayList<AbstractValidate> _validates = new ArrayList<AbstractValidate>();
	
	/**
	 * Fonction rajoutant des Validateurs à notre formulaire
	 * @param validate
	 */
	public void addValidates(AbstractValidate validate){
		this._validates.add(validate);
		return;
	}
	
	/**
	 * Fonction appelée pour valider notre formulaire.
	 * Si une erreur a été trouvée, elle sera affichée dans le champs correspondant.
	 * @return
	 * 		boolean : true si le formulaire est valide
	 *                false si le formulaire est invalide
	 */
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
