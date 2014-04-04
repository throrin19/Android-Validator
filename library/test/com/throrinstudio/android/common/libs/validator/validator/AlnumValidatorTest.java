package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;

import com.throrinstudio.android.common.libs.validator.RobolectricGradleTestRunner;
import com.throrinstudio.android.common.libs.validator.validator.AlnumValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by piobab on 03.04.2014.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class AlnumValidatorTest {

    @Test
    public void validateWithAllNumbers() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        AlnumValidator alnumValidator = new AlnumValidator(context);
        assertTrue(alnumValidator.isValid("1234567890"));
        assertFalse(alnumValidator.isValid("abcdef"));
        assertTrue(alnumValidator.isValid(""));
    }
}
