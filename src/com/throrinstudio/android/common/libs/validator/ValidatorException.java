package com.throrinstudio.android.common.libs.validator;

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
