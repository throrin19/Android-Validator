package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

public class EmailValidator extends AbstractValidator {

	private int mErrorMessage = R.string.validator_email;
	

	private String mDomainName = "";
	
	public EmailValidator(Context c) {
		super(c);
	}
	
	@Override
	public boolean isValid(Object value) {
		CharSequence charseq = (CharSequence) value;
		
		if(charseq.length() > 0 ){
			boolean matchFound = false;
			
			//Input the string for validation
			String email = charseq.toString();
			 
			if(mDomainName != null && mDomainName.length() > 0){
				//Test avec le domaine
				
			    //Set the email pattern string
			    Pattern p = Pattern.compile(".+@"+mDomainName);
			    //Match the given string with the pattern
			    Matcher m = p.matcher(email);
			    //check whether match is found 
			    matchFound = m.matches();
		
			    if (matchFound)
			        return true;
			    else
			        return false;
			}else{
				//test sans le domaine
				
			    //Set the email pattern string
			    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			    //Match the given string with the pattern
			    Matcher m = p.matcher(email);
			    //check whether match is found 
			    matchFound = m.matches();
			}
			
			if (matchFound)
		        return true;
		    else
		        return false;
		}else{
			return true;
		}
	}
	
	@Override
	public String getMessage() {
		return mContext.getString(mErrorMessage);
	}
	
	/**
	 * Permet de dire que l'adresse email doit être de tel domaine pour être valide.
	 * Cette fonction n'accepte que les chaines de Regexp
	 * @param name nom de domaine
	 * 
	 * example : gmail.com
	 */
	public void setDomainName(String name){
		mDomainName = name;
	}
}
