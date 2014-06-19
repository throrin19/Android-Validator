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
public class HexValidatorTest {

    @Test
    public void validateHexNumber() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        HexValidator hexValidator = new HexValidator(context);
        assertTrue(hexValidator.isValid("1234567890abcdef"));
        assertTrue(hexValidator.isValid("#12FF"));
        assertFalse(hexValidator.isValid("abcdefg"));
        assertFalse(hexValidator.isValid(""));
    }
}
