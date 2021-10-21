package com.app.inventoryapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GetStoresResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public GetStoresResponse() {
    }

    /**
     *
     * @param success
     * @param stores
     * @param message
     * @param statusCode
     */
    public GetStoresResponse(Boolean success, Integer statusCode, String message, List<Store> stores) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.stores = stores;
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

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

}
