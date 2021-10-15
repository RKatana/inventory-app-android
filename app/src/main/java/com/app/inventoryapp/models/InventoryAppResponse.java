
package com.app.inventoryapp.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InventoryAppResponse implements Serializable
{

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("statusCode")
    @Expose
    private long statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private User user;
    private final static long serialVersionUID = 344192972363739975L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InventoryAppResponse() {
    }

    /**
     * 
     * @param success
     * @param message
     * @param user
     * @param statusCode
     */
    public InventoryAppResponse(boolean success, long statusCode, String message, User user) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
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
