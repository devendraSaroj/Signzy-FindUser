package com.devendra_saroj.finduser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {


    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar")
    @Expose
    private String avatarUrl;
    @SerializedName("html_url")
    @Expose
    private String html_url;

    public  Item(String login, String avatarUrl, String html_url) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.html_url = html_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.login = avatarUrl;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.login = html_url;
    }




}
