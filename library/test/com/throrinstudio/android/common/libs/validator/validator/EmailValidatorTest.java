package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.RobolectricGradleTestRunner;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by piobab on 03.04.2014.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class EmailValidatorTest {

    @Test
    public void validateEmailWithoutDomainApplied() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        EmailValidator emailValidator = new EmailValidator(context);
        assertTrue(emailValidator.isValid("email@yahoo.com"));
        assertFalse(emailValidator.isValid("abcdef"));
        assertFalse(emailValidator.isValid(""));
        assertFalse(emailValidator.isValid("email@"));
        assertFalse(emailValidator.isValid("@gmail.com"));
    }

    @Test
    public void validateEmailWithDomainApplied() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        EmailValidator emailValidator = new EmailValidator(context);
        emailValidator.setDomainName("gmail.com");
        assertTrue(emailValidator.isValid("email@gmail.com"));
        assertFalse(emailValidator.isValid("email@yahoo.com"));
        assertFalse(emailValidator.isValid("abcdef"));
        assertFalse(emailValidator.isValid(""));
        assertFalse(emailValidator.isValid("email@"));
        assertFalse(emailValidator.isValid("@gmail.com"));
    }
}
