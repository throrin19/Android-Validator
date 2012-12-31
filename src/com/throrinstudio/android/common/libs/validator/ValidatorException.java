package com.throrinstudio.android.common.libs.validator;

/**
 * Created with IntelliJ IDEA.
 * User: throrin19
 * Date: 31/12/12
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class ValidatorException extends java.lang.Exception{
    private static final long serialVersionUID = 1L;

    public ValidatorException() {
        super();
    }

    /**
     * @param detailMessage
     * @param throwable
     */
    public ValidatorException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * @param detailMessage
     */
    public ValidatorException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * @param throwable
     */
    public ValidatorException(Throwable throwable) {
        super(throwable);
    }
}
