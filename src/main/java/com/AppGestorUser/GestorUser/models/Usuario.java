package com.AppGestorUser.GestorUser.models;

public class Usuario {

    private String name;
    private String last_name;
    private String email;
    private String telephone_number;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
