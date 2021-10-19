package com.app.inventoryapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegisterUserResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     * No args constructor for use in serialization
     *
     */
    public RegisterUserResponse() {
    }

    /**
     *
     * @param success
     * @param message
     * @param user
     * @param statusCode
     */
    public RegisterUserResponse(Boolean success, Integer statusCode, String message, User user) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.user = user;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}