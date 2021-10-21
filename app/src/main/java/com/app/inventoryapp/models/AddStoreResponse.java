package com.app.inventoryapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AddStoreResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("store")
    @Expose
    private Store store;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddStoreResponse() {
    }

    /**
     *
     * @param success
     * @param store
     * @param message
     * @param statusCode
     */
    public AddStoreResponse(Boolean success, Integer statusCode, String message, Store store) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.store = store;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
