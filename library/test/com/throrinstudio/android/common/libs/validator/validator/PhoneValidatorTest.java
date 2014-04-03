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
public class PhoneValidatorTest {

    @Test
    public void validatePhoneNumber() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        PhoneValidator phoneValidator = new PhoneValidator(context);
        assertTrue(phoneValidator.isValid("048123456789"));
        assertTrue(phoneValidator.isValid("+48123456789"));
        assertTrue(phoneValidator.isValid("600456789"));
        assertTrue(phoneValidator.isValid("600456"));
        assertFalse(phoneValidator.isValid(""));
        assertFalse(phoneValidator.isValid("abcdef10"));
    }
}
