package com.app.inventoryapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("buying_price")
    @Expose
    private Integer buyingPrice;
    @SerializedName("selling_price")
    @Expose
    private Integer sellingPrice;
    @SerializedName("spoilt")
    @Expose
    private Integer spoilt;
    @SerializedName("payment_status")
    @Expose
    private Boolean paymentStatus;
    @SerializedName("date_received")
    @Expose
    private String dateReceived;
    @SerializedName("store")
    @Expose
    private Integer store;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param uid
     * @param sellingPrice
     * @param quantity
     * @param buyingPrice
     * @param spoilt
     * @param dateReceived
     * @param name
     * @param id
     * @param store
     * @param paymentStatus
     */
    public Product(Integer id, String uid, String name, Integer quantity, Integer buyingPrice, Integer sellingPrice, Integer spoilt, Boolean paymentStatus, String dateReceived, Integer store) {
        super();
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.spoilt = spoilt;
        this.paymentStatus = paymentStatus;
        this.dateReceived = dateReceived;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Integer buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getSpoilt() {
        return spoilt;
    }

    public void setSpoilt(Integer spoilt) {
        this.spoilt = spoilt;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

}