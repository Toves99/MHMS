package com.example.modern.HMS.dto;

public class Response {
    public String status;
    public String message;
    public Object data;

    public static enum STATUS{
        Success,Failed;
    }
    public Response() {
       this.status = STATUS.Success.toString();
    }
}
