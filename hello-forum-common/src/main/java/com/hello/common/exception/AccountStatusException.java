package com.hello.common.exception;


/**
 * 账号不存在异常
 */
public class AccountStatusException extends BaseException {

    public AccountStatusException() {
    }

    public AccountStatusException(String msg) {
        super(msg);
    }

}
