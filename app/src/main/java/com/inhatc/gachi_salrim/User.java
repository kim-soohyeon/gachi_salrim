package com.inhatc.gachi_salrim;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String name;
    public String id;
    public String pw;
    public String email;
    public String phone;
    public String area;

    public User(){}

    public User(String name,String id,String pw,String email,String phone,String area)
    {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getArea() {
        return area;
    }
}
