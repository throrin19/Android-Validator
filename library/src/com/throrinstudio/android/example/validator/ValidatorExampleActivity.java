package com.throrinstudio.android.example.validator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validate.ConfirmValidate;
import com.throrinstudio.android.common.libs.validator.validate.OrTwoRequiredValidate;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.throrinstudio.android.common.libs.validator.validator.UrlValidator;
import com.throrinstudio.android.common.libs.widgets.OkCancelBar;

public class ValidatorExampleActivity extends Activity
{
	private EditText required;
	private EditText orRequired1;
	private EditText email;
	private EditText password;
	private EditText confirmPassword;
    private EditText url;
	
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
        url             = (EditText) findViewById(R.id.url);
        
        mForm = new Form();
        
        Validate requiredField = new Validate(required);
        requiredField.addValidator(new NotEmptyValidator(this));
        
        OrTwoRequiredValidate orRequiredVal = new OrTwoRequiredValidate(orRequired1, email);
        
        Validate emailField = new Validate(email);
        EmailValidator mailVal = new EmailValidator(this);
        mailVal.setDomainName("gmail\\.com");
        emailField.addValidator(mailVal);
        
        ConfirmValidate confirmFields = new ConfirmValidate(password, confirmPassword);

        Validate urlValidator = new Validate(url);
        urlValidator.addValidator(new UrlValidator(this));

        mForm.addValidates(requiredField);
        mForm.addValidates(orRequiredVal);
        mForm.addValidates(emailField);
        mForm.addValidates(confirmFields);
        mForm.addValidates(urlValidator);
        
        
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
