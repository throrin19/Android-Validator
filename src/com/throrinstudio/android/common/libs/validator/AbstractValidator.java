package com.throrinstudio.android.common.libs.validator;

import android.content.Context;

/**
 * Classe servant à créer de nouveaux Validators
 * @author throrin19
 *
 */
public abstract class AbstractValidator {

	protected Context mContext;
	
	public AbstractValidator(Context c){
		mContext = c;
	}
	
	/**
	 * Permet de vérifier si la valeur passée en paramètre est valide ou non.
	 * @param value
	 * 		{@link Object} : la valeur à valider
	 * @return
	 * 		boolean : true si valide, false sinon.
	 */
	public abstract boolean isValid(Object value);
	
	/**
	 * Permet de récupérer le message d'erreur correspondant au validateur.
	 * @return
	 * 		String : le message d'erreur
	 */
	public abstract String getMessage();
}
