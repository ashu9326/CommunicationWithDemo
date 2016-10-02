package com.example.ashutosh.communicationwithdemo.model;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public class Contact {
    private String name ,  email ,mobile;

    public Contact(String name, String email ) {
        this.name = name;
        this.email = email;
        ///this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
