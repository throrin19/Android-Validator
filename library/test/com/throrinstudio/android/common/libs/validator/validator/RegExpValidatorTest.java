package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.RobolectricGradleTestRunner;
import com.throrinstudio.android.common.libs.validator.ValidatorException;
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
public class RegExpValidatorTest {

    @Test
    public void validateWithoutRegularExpressionSpecified() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        RegExpValidator regExpValidator = new RegExpValidator(context);
        boolean valid = true;
        try {
            // Should throw exception
            regExpValidator.isValid("1234567890abcdef");
        } catch (ValidatorException ve) {
            valid = false;
        }
        assertFalse(valid);
    }

    @Test
    public void validateIpAddress() throws Exception {
        String ipAddressPattern = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        RegExpValidator regExpValidator = new RegExpValidator(context);
        regExpValidator.setPattern(ipAddressPattern);
        assertTrue(regExpValidator.isValid("127.0.0.1"));
        assertTrue(regExpValidator.isValid("255.0.0.0"));
        assertTrue(regExpValidator.isValid("255.255.255.255"));
        assertTrue(regExpValidator.isValid("0.0.0.0"));
        assertFalse(regExpValidator.isValid("127.0"));
    }
}
