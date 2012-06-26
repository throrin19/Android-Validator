package com.throrinstudio.android.library.validator.editText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;

import com.throrinstudio.android.example.R;
import com.throrinstudio.android.library.validator.Validator;

public class EmailValidator extends Validator {

	private int mErrorMessage = R.string.validator_email;
	
	public EmailValidator(Context c) {
		super(c);
	}
	
	@Override
	public boolean isValid(Object value) {
		CharSequence charseq = (CharSequence) value;
		
		if(charseq.length() > 0 ){
			//Input the string for validation
		    String email = charseq.toString();
	
		    //Set the email pattern string
		    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	
		    //Match the given string with the pattern
		    Matcher m = p.matcher(email);
	
		    //check whether match is found 
		    boolean matchFound = m.matches();
	
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
}
