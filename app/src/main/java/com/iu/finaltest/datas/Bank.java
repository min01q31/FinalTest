package com.iu.finaltest.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Bank implements Serializable {

    private int id;
    private String name;
    private String code;
    private String logoUrl;



    public static Bank getBankFromJson(JSONObject bankJson){
        Bank bank = new Bank();

        try {
            bank.setId(bankJson.getInt("id"));
            bank.setName(bankJson.getString("name"));
            bank.setCode(bankJson.getString("code"));
            bank.setLogoUrl(bankJson.getString("logo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
