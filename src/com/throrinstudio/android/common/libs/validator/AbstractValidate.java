package com.throrinstudio.android.common.libs.validator;

import android.widget.TextView;

public abstract class AbstractValidate {

	/**
	 * Permet d'ajouter un nouveau Validator pour le champs rattaché
	 * @param validator
	 * 		{@link AbstractValidator} : Le validator à rattacher
	 */
	public abstract void addValidator(AbstractValidator validator);
	
	/**
	 * Fonction appelée lors de la validation {@link Form}
	 * @param value
	 * 		{@link Object} : valeur à valider
	 * @return
	 * 		true si tous les validateurs sont valides
	 *      false si un des validateurs est invalide
	 */
	public abstract boolean isValid(Object value);
	
	/**
	 * Retourne le message d'erreur à afficher sur l'élément rattaché
	 * @return
	 * 		{@link String} : le message � afficher
	 */
	public abstract String getMessages();
	
	/**
	 * Fonction récupérant le champs rattaché à notre validateur
	 * @return
	 * 		{@link TextView} : Le champs rattaché
	 */
	public abstract TextView getSource();
}
