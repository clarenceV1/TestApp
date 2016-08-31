package com.example.clarence.myapp.data;

import java.io.Serializable;

/**
 * Created by clarence on 16/8/31.
 */
public class UserInfoDO implements Serializable {
    private String name;
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
