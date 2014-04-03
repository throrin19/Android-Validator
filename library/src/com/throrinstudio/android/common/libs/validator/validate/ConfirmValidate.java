package com.throrinstudio.android.common.libs.validator.validate;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.validator.AbstractValidate;
import com.throrinstudio.android.common.libs.validator.R;

public class ConfirmValidate extends AbstractValidate {

    private static final int CONFIRM_ERROR_MESSAGE = R.string.validator_confirm;
    private TextView mFirstField;
    private TextView mSecondField;
    private Context mContext;
    private TextView mSourceView;

    public ConfirmValidate(TextView field1, TextView field2) {
        mFirstField = field1;
        mSecondField = field2;
        mSourceView = mSecondField;
        mContext = mSourceView.getContext();
    }

    @Override
    public boolean isValid() {
        final String firstFieldTxt = mFirstField.getText().toString();
        final String secondFieldTxt = mSecondField.getText().toString();
        if (isNotEmpty(firstFieldTxt) && firstFieldTxt.equals(secondFieldTxt)) {
            mSourceView.setError(null);
            return true;
        } else {
            mSourceView.setError(mContext.getString(CONFIRM_ERROR_MESSAGE));
            return false;
        }
    }

    private boolean isNotEmpty(String text) {
        return !TextUtils.isEmpty(text);
    }

    public TextView getSource() {
        return mSourceView;
    }
}
