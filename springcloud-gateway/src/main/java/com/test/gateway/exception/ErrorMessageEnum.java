package com.test.gateway.exception;

public enum  ErrorMessageEnum {

    INTERAL_ERROR(500,"服务器内部错误！"),

    MQ_SERVICE_EXECUTE_ERROR(10001,"MQ服务调用失败！");

    private static final String EMPTY = "";

    private int errCode;

    private String errMsg;

    /**
     * * Get message by code
     * * @param code
     *
     * @return name
     */
    public static String getText(int code) {
        for (ErrorMessageEnum em : ErrorMessageEnum.values()) {
            if (em.errCode == code) {
                return em.errMsg;
            }
        }
        return EMPTY;
    }

    ErrorMessageEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
