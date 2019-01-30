package com.idealo.robot.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errCode;

    public BusinessException(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
