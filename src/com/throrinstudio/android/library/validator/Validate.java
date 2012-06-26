package com.throrinstudio.android.library.validator;

import java.util.ArrayList;
import java.util.Iterator;

import android.widget.TextView;


public class Validate extends AbstractValidate{

	/**
     * Validator chain
     */
    protected ArrayList<Validator> _validators = new ArrayList<Validator>();
    
    /**
     * Array of validation failure messages
     */
    protected String _message = new String();
    
    /**
     * 
     */
    protected TextView _source;
    
    
    public Validate(TextView source){
    	this._source = source;
    }
    
    /**
     * Adds a validator to the end of the chain
     *
     * If $breakChainOnFailure is true, then if the validator fails, the next validator in the chain,
     * if one exists, will not be executed.
     *
     * @param Validator 
     */
    public void addValidator(Validator validator)
    {
    	this._validators.add(validator);
    	return;
    }
    
    public boolean isValid(Object value){
    	boolean result = true;
    	this._message = new String();
    	
    	Iterator<Validator> it = this._validators.iterator();
    	while(it.hasNext()){
    		Validator validator = it.next();
    		if(!validator.isValid(value)){
    			this._message = validator.getMessage();
    			result = false;
    			break;
    		}
    	}
    	
    	return result;
    }
    
    public String getMessages(){
    	return this._message;
    }
    
    public TextView getSource(){
    	return this._source;
    }
    
}
