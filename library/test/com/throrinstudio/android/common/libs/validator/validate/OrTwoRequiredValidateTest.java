package com.throrinstudio.android.common.libs.validator.validate;

import android.content.Context;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.validator.RobolectricGradleTestRunner;
import com.throrinstudio.android.common.libs.validator.validate.OrTwoRequiredValidate;

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
public class OrTwoRequiredValidateTest {

    private Context mContext;
    private TextView mFirstField;
    private TextView mSecondField;

    @Before
    public void setup() {
        mContext = Robolectric.getShadowApplication().getApplicationContext();
        mFirstField = new TextView(mContext);
        mSecondField = new TextView(mContext);
    }

    @Test
    public void validateEmptyFields() throws Exception {
        mFirstField.setText("");
        mSecondField.setText("");

        OrTwoRequiredValidate orTwoRequiredValidate = new OrTwoRequiredValidate(mFirstField, mSecondField);
        assertFalse(orTwoRequiredValidate.isValid());
    }

    @Test
    public void validateFirstFieldEmpty() throws Exception {
        mFirstField.setText("");
        mSecondField.setText("abcdef");

        OrTwoRequiredValidate orTwoRequiredValidate = new OrTwoRequiredValidate(mFirstField, mSecondField);
        assertTrue(orTwoRequiredValidate.isValid());
    }

    @Test
    public void validateSecondFieldEmpty() throws Exception {
        mFirstField.setText("abcdef");
        mSecondField.setText("");

        OrTwoRequiredValidate orTwoRequiredValidate = new OrTwoRequiredValidate(mFirstField, mSecondField);
        assertTrue(orTwoRequiredValidate.isValid());
    }
}
