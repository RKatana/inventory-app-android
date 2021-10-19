package com.app.inventoryapp.models;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse implements Serializable
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
    @SerializedName("access")
    @Expose
    private String access;
    @SerializedName("refresh")
    @Expose
    private String refresh;
    @SerializedName("authenticatedUser")
    @Expose
    private AuthenticatedUser authenticatedUser;
    private final static long serialVersionUID = 3987089124122239444L;
    /**
     * No args constructor for use in serialization
     *
     */
    public LoginResponse() {
    }
    /**
     *
     * @param access
     * @param success
     * @param refresh
     * @param authenticatedUser
     * @param message
     * @param statusCode
     */
    public LoginResponse(boolean success, long statusCode, String message, String access, String refresh, AuthenticatedUser authenticatedUser) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.access = access;
        this.refresh = refresh;
        this.authenticatedUser = authenticatedUser;
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
    public String getAccess() {
        return access;
    }
    public void setAccess(String access) {
        this.access = access;
    }
    public String getRefresh() {
        return refresh;
    }
    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
    public AuthenticatedUser getAuthenticatedUser() {
        return authenticatedUser;
    }
    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
}
