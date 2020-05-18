package com.example.appmotoseguros.model;

public class Login {

    private String accesstoken;
    private String token_type;
    private String expire_in;
    private String error;

    public Login(String accesstoken, String token_type, String expire_in) {
        this.accesstoken = accesstoken;
        this.token_type = token_type;
        this.expire_in = expire_in;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getExpire_in() {
        return expire_in;
    }

    public String isError() {
        return error;
    }
}
