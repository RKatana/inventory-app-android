package com.app.inventoryapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AddProductResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("product")
    @Expose
    private Product product;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddProductResponse() {
    }

    /**
     *
     * @param product
     * @param success
     * @param message
     * @param statusCode
     */
    public AddProductResponse(Boolean success, Integer statusCode, String message, Product product) {
        super();
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
