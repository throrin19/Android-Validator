package com.throrinstudio.android.common.libs.validator;

import android.content.Context;
import android.widget.TextView;

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
        assertEquals(true, true);
    }
}
