package com.sizuk.armorworkshop.dao.dto;

/**
 * Created by Игорь on 25.07.2016.
 */
public class Admin {
    private int id;
    private String password;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
