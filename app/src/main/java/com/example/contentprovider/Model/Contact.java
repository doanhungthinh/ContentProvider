package com.example.contentprovider.Model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String Phone;

    public Contact(String name, String phone)  {
        this.name = name;
        this.Phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Ten: "+this.name+"\nPhone: "+this.Phone;
    }
}
