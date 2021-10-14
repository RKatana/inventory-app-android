package com.app.inventoryapp.models;

import org.parceler.Parcel;

public class Attendant {
    private int id;
    private String name;
    private String email;
    private String password;
    private String accessLevel;
    private int store_id;

    public Attendant(String name, String email, String password,String accessLevel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    @Override
    public String toString() {
        return "Attendant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", store_id=" + store_id +
                '}';
    }
}
