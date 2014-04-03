package com.throrinstudio.android.common.libs.validator;

import android.content.Context;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.AlnumValidator;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;
import com.throrinstudio.android.common.libs.validator.validator.HexValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.throrinstudio.android.common.libs.validator.validator.PhoneValidator;
import com.throrinstudio.android.common.libs.validator.validator.UrlValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by piobab on 03.04.2014.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class ValidateText {

    @Test
    public void validateWithoutAnyValidators() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        Validate validate = new Validate(textView);
        assertTrue(validate.isValid());
    }

    @Test
    public void validateNotEmptyField() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        textView.setText("validate");
        Validate validate = new Validate(textView);
        validate.addValidator(new NotEmptyValidator(context));
        assertTrue(validate.isValid());
        textView.setText("");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateNotEmptyWithAlnumField() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        textView.setText("1234567890");
        Validate validate = new Validate(textView);
        validate.addValidator(new NotEmptyValidator(context));
        validate.addValidator(new AlnumValidator(context));
        assertTrue(validate.isValid());
        textView.setText("");
        assertFalse(validate.isValid());
        textView.setText("abcdef");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateNotEmptyWithEmailField() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        textView.setText("email@yahoo.com");
        Validate validate = new Validate(textView);
        validate.addValidator(new NotEmptyValidator(context));
        validate.addValidator(new EmailValidator(context));
        assertTrue(validate.isValid());
        textView.setText("");
        assertFalse(validate.isValid());
        textView.setText("@gmail.com");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateNotEmptyWithPhoneField() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        textView.setText("+48600123456");
        Validate validate = new Validate(textView);
        validate.addValidator(new NotEmptyValidator(context));
        validate.addValidator(new PhoneValidator(context));
        assertTrue(validate.isValid());
        textView.setText("");
        assertFalse(validate.isValid());
        textView.setText("abcde_fgh");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateNotEmptyWithHexField() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        textView.setText("1234567890abcdef");
        Validate validate = new Validate(textView);
        validate.addValidator(new NotEmptyValidator(context));
        validate.addValidator(new HexValidator(context));
        assertTrue(validate.isValid());
        textView.setText("");
        assertFalse(validate.isValid());
        textView.setText("abcdefg");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateNotEmptyWithUrlField() throws Exception {
        Context context = Robolectric.getShadowApplication().getApplicationContext();
        TextView textView = new TextView(context);
        textView.setText("http://www.github.com/test/");
        Validate validate = new Validate(textView);
        validate.addValidator(new NotEmptyValidator(context));
        validate.addValidator(new UrlValidator(context));
        assertTrue(validate.isValid());
        textView.setText("");
        assertFalse(validate.isValid());
        textView.setText("test");
        assertFalse(validate.isValid());
    }
}
