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
public class NotEmptyValidatorTest {

    @Test
    public void isNotEmpty() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        NotEmptyValidator notEmptyValidator = new NotEmptyValidator(context);
        assertTrue(notEmptyValidator.isValid("abcdef"));
        assertTrue(notEmptyValidator.isValid(" "));
        assertFalse(notEmptyValidator.isValid(""));
    }
}
