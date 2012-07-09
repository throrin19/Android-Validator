package com.throrinstudio.android.example;

import com.throrinstudio.android.library.validator.Form;
import com.throrinstudio.android.library.validator.Validate;
import com.throrinstudio.android.library.validator.editText.ConfirmValidator;
import com.throrinstudio.android.library.validator.editText.EmailValidator;
import com.throrinstudio.android.library.validator.editText.NotEmptyValidator;
import com.throrinstudio.android.library.validator.editText.OrTwoFieldsEmptyValidator;
import com.throrinstudio.android.library.widgets.OkCancelBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class ValidatorExampleActivity extends Activity
{
	private EditText required;
	private EditText orRequired1;
	private EditText email;
	private EditText password;
	private EditText confirmPassword;
	
	private Form mForm;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        OkCancelBar bar = (OkCancelBar) findViewById(R.id.okCancelBar);
        
        required 		= (EditText) findViewById(R.id.required);
        orRequired1 	= (EditText) findViewById(R.id.orrequired1);
        email 			= (EditText) findViewById(R.id.email);
        password 		= (EditText) findViewById(R.id.password1);
        confirmPassword = (EditText) findViewById(R.id.password2);
        
        mForm = new Form();
        
        Validate requiredField = new Validate(required);
        requiredField.addValidator(new NotEmptyValidator(this));
        
        OrTwoFieldsEmptyValidator orRequiredVal = new OrTwoFieldsEmptyValidator(orRequired1, email);
        
        Validate emailField = new Validate(email);
        emailField.addValidator(new EmailValidator(this));
        
        ConfirmValidator confirmFields = new ConfirmValidator(password, confirmPassword);
        
        mForm.addValidates(requiredField);
        mForm.addValidates(orRequiredVal);
        mForm.addValidates(emailField);
        mForm.addValidates(confirmFields);
        
        
        bar.getOkButton().setOnClickListener(validateForm);
    }
    
    private OnClickListener validateForm = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(mForm.validate()){
				Toast.makeText(getApplicationContext(), "Valid Form", Toast.LENGTH_LONG).show();
			}
		}
	};
}
