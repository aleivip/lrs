package com.lrs.money.commn;

/**
 * @program: money
 * @description:
 * @author: alei
 * @create: 2019-10-11 21:12
 **/

public class ResultMsg {

    private String code;
    private String message;
    private Object data;
    private String account;
    private String password;


    public ResultMsg() {
    }

    public ResultMsg(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultMsg(String code, String message, String account, String password) {
        this.code = code;
        this.message = message;
        this.account = account;
        this.password = password;
    }



    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
