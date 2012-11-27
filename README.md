Android-Validator
=================

Form Validator Library for Android

Presentation
------------

Form Validator Library for Android is based on [Zend_Validator](http://framework.zend.com/manual/1.12/en/zend.validate.introduction.html, "Title") coded in PHP. This library is intended to simplify and streamline the code to validate a form Android. For the moment, the form can just handle the **EditText**. Other elements will emerge in future versions.

### License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

Use
---

Form Validator Library is composed of 3 members : 
-   **Form :** Contains all beings validates to treat. This is the Form that manages the display of error messages in the various elements.
-   **Validate :** Contains all the validators to be treated for a given element.
-   **Validator :** Can define a validation rule.

### Validator

The validator is basic class for this library. It contains specific validation rules. To instanciate validator, you just have to do this (EmailValidator for example):
    new EmailValidator(context);

For some validators, functions can change the validation rules. The validator currently contains three basic validation rules:
+   **EmailValidator**
+   **NotEmptyValidator**
+   **UrlValidator**