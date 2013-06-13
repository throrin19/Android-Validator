Android-Validator
=================

Form Validator Library for Android

Presentation
------------

Form Validator Library for Android is based on [Zend_Validator](http://framework.zend.com/manual/1.12/en/zend.validate.introduction.html, "Title") coded in PHP. This library is intended to simplify and streamline the code to validate a form Android. For the moment, the form can just handle the **EditText**. Other elements will emerge in future versions.

### License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

Requirement
-----------

+   Android 2.2+

Use
---

Form Validator Library is composed of 3 members : 
-   **Form :** Contains all beings validates to treat. This is the Form that manages the display of error messages in the various elements.
-   **Validate :** Contains all the validators to be treated for a given element.
-   **Validator :** Can define a validation rule.

### Validator

The validator is basic class for this library. It contains specific validation rules. To instanciate validator, you just have to do this (EmailValidator for example):

``` java
new EmailValidator(context);
```

For some validators, functions can change the validation rules. The validator currently contains three basic validation rules:
+   **EmailValidator** : Ensures that the field does contain a email address. You can also define a regex to check for a particular domain name with the function `setDomainName(DomainRegexp)`. Example for **gmail.com** domain : `setDomainName("gmail\\.com")`. 
+   **NotEmptyValidator** : Ensures that the field is not empty.
+   **UrlValidator** : Ensures that the field is a valid url.
+   **AlnumValidator** : Ensure that the feld has Alnum characters.
+   **HexValidator** : Ensure that the field has Hex characters.
+   **RegExpPattern** : Ensure that the field does match setted Pattern.
+   **PhoneValidator** : Ensure that the field is a valid phone number.
+   **Custom Validator** : You can create your own Validator. To do this, you can just create class extends AbstractValidator :

``` java
public class CustomValidator extends AbstractValidator
{
    private int mErrorMessage = R.string.validator_custom; // Your custom error message

    public CustomValidator(Context c) {
        super(c);
    }

    @Override
    public boolean isValid(Object value) {
        // Your validation Test is here.
        // Retour true if it's correct, false if it's incorrect
        return true;
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
```
    
### Validate

The pure Validate class is a FIFO validator. It's test a list of AbstractValidator for specific EditText. For some special cases, Validate is not enough. This is why there are specific validates. This is why there are two individuals with a Validate operation different from that base :
+   **ConfirmValidate** : Can check whether a value is identical between the two fields. Can be used to confirm the entry of a password.
+   **OrTwoRequiredValidate** : If one of the two target fields has a value, then it is valid. Can be used if a user must give his phone **or** fax.
+   **Validate** : The base Validate. It creates his validators stack.

Basicly, Validate can only handle a single EditText. If you want to manage several at the same time, see if **ConfirmValidate ** or **OrTwoRequiredValidate ** match your problem. If this is not the case, you may need to create your own Validate. To instantiate a Validate, you just have to do this:
``` java
Validate emailField = new Validate(email);
```

And to add Validator stack, for example to add a required Email field, you have to do this:
``` java
emailField.addValidator(new NotEmptyValidator(mContext));
emailField.addValidator(new EmailValidator(mContext));
```

### Form

The Form class is the class teacher of the whole Library. It is this which manages the processing of each Validate, Validator and displays the error on the EditText automatically. The Form class stores a Validate stack and then you just have to run the validation with the `validate()` function.
To instanciate Form and add Validates, you have to do this :
``` java
Form mForm = new Form();
mForm.addValidates(emailField);
mForm.addValidates(confirmFields);
mForm.addValidates(urlField);

// ...

// Launch Validation
if(mForm.validate()){
    // success statement
}else{
    // error statement like toast, crouton, ...
}
```

### Changelog

+   **0.1** : Create library
+   **0.2** : Add ConfirmValidate and OrTwoRequiredValidate
+   **0.3** : Extends EmailValidator with `setDomainName()`
+   **0.4** : Replace Validator by AbstractValidator
+   **0.5** : Fix bug in UrlValidator
+   **1.0** : Add AlnumValidator, HexValidator, RegExpValidator, ValidatorException. Fix Validate class.
+   **1.1** : Go to Android 2.2 for android.util.Patterns. Add PhoneValidator. Edit UrlValidator.
