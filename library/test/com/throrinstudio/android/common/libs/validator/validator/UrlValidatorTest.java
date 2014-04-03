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
public class UrlValidatorTest {

    @Test
    public void validateUrl() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        UrlValidator urlValidator = new UrlValidator(context);
        assertTrue(urlValidator.isValid("www.google.com"));
        assertTrue(urlValidator.isValid("http://www.wp.pl/"));
        assertTrue(urlValidator.isValid("http://github.com"));
        assertFalse(urlValidator.isValid("htp://twitter.com"));
        assertFalse(urlValidator.isValid("http://twitter"));
    }
}
