package com.essContext.Exception;

public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -239866202331773707L;

    private String code;

    private String message;

    public ServiceException() {
        super();
        this.code = "999999";
        this.message = "逻辑错误";
    }

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(Exception cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
