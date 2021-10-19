package com.app.inventoryapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AuthenticatedUser {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("role")
    @Expose
    private String role;

    /**
     * No args constructor for use in serialization
     *
     */
    public AuthenticatedUser() {
    }

    /**
     *
     * @param role
     * @param email
     */
    public AuthenticatedUser(String email, String role) {
        super();
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
