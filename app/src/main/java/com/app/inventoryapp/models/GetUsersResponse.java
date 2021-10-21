package com.app.inventoryapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUsersResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("users")
    @Expose
    private List<Attendant> users = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public GetUsersResponse() {
    }

    /**
     *
     * @param success
     * @param message
     * @param users
     * @param statusCode
     */
    public GetUsersResponse(Boolean success, Integer statusCode, String message, List<Attendant> users) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.users = users;
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

    public List<Attendant> getUsers() {
        return users;
    }

    public void setUsers(List<Attendant> users) {
        this.users = users;
    }

}
