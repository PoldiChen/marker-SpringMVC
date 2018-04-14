package com.marker.pojo;

public class Resp {

    private int code;
    private Object data;
    private String message;

    public Resp() {
        this.code = 0;
        this.message = "ok";
        this.data = null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
