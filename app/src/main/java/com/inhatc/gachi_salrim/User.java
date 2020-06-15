package com.inhatc.gachi_salrim;



import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String name;
    public String id;
    public String pw;
    public String email;
    public String phone;

    public User(){}

    public User(String name,String id,String pw,String email,String phone)
    {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
    }
}
