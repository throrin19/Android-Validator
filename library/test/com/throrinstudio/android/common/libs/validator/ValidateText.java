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
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by piobab on 03.04.2014.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class ValidateText {

    private Context mContext;
    private TextView mField;

    @Before
    public void setup() {
        mContext = Robolectric.getShadowApplication().getApplicationContext();
        mField = new TextView(mContext);
    }

    @Test
    public void validateFieldWithoutAnyValidators() throws Exception {
        Validate validate = new Validate(mField);
        assertTrue(validate.isValid());
    }

    @Test
    public void validateFieldWithNotEmptyValidator() throws Exception {
        mField.setText("validate");
        Validate validate = new Validate(mField);
        validate.addValidator(new NotEmptyValidator(mContext));
        assertTrue(validate.isValid());
        mField.setText("");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateFieldWithNotEmptyAndAlnumValidators() throws Exception {
        mField.setText("1234567890");
        Validate validate = new Validate(mField);
        validate.addValidator(new NotEmptyValidator(mContext));
        validate.addValidator(new AlnumValidator(mContext));
        assertTrue(validate.isValid());
        mField.setText("");
        assertFalse(validate.isValid());
        mField.setText("abcdef");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateFieldWithNotEmptyAndEmailValidators() throws Exception {
        mField.setText("email@yahoo.com");
        Validate validate = new Validate(mField);
        validate.addValidator(new NotEmptyValidator(mContext));
        validate.addValidator(new EmailValidator(mContext));
        assertTrue(validate.isValid());
        mField.setText("");
        assertFalse(validate.isValid());
        mField.setText("@gmail.com");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateFieldWithNotEmptyAndPhoneValidators() throws Exception {
        mField.setText("+48600123456");
        Validate validate = new Validate(mField);
        validate.addValidator(new NotEmptyValidator(mContext));
        validate.addValidator(new PhoneValidator(mContext));
        assertTrue(validate.isValid());
        mField.setText("");
        assertFalse(validate.isValid());
        mField.setText("abcde_fgh");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateFieldWithNotEmptyAndHexValidators() throws Exception {
        mField.setText("1234567890abcdef");
        Validate validate = new Validate(mField);
        validate.addValidator(new NotEmptyValidator(mContext));
        validate.addValidator(new HexValidator(mContext));
        assertTrue(validate.isValid());
        mField.setText("");
        assertFalse(validate.isValid());
        mField.setText("abcdefg");
        assertFalse(validate.isValid());
    }

    @Test
    public void validateFieldWithNotEmptyAndUrlValidators() throws Exception {
        mField.setText("http://www.github.com/test/");
        Validate validate = new Validate(mField);
        validate.addValidator(new NotEmptyValidator(mContext));
        validate.addValidator(new UrlValidator(mContext));
        assertTrue(validate.isValid());
        mField.setText("");
        assertFalse(validate.isValid());
        mField.setText("test");
        assertFalse(validate.isValid());
    }
}
