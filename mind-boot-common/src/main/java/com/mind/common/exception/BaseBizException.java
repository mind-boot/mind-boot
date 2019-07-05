package com.mind.common.exception;

/**
 * service业务处理异常
 *
 * @author caoyong
 * @since 2018年1月29日 上午11:40:49
 */

public class BaseBizException extends Exception {
    private static final long serialVersionUID = 5067417386461048288L;
    private String errorCode;

    public BaseBizException() {
        super();
    }

    public BaseBizException(String errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;

    }

    public BaseBizException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
