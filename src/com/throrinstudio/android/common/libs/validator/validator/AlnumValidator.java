package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.example.validator.R;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: throrin19
 * Date: 31/12/12
 *
 * Validateur permettant de vérifier si un champs contient bien seulement et uniquement des chiffres et des lettres.
 * Permet d'éviter d'avoir des caractères spéciaux comme les accents.
 */
public class AlnumValidator extends AbstractValidator{

    /**
     * This si Alnum Pattern to verify value.
     */
    private static final Pattern mPattern = Pattern.compile("^[A-Za-z0-9]+$");

    private int mErrorMessage = R.string.validator_alnum;

    public AlnumValidator(Context c) {
        super(c);
    }

    @Override
    public boolean isValid(Object value) {
        if(value != null){
            value = "";
        }

        return mPattern.matcher((String)value).matches();
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
