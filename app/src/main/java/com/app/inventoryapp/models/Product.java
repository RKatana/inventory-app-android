package com.app.inventoryapp.models;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int buyingPrice;
    private int sellingPrice;
    private int spoilt;
    private boolean paymentStatus;
    private int store_id;

    public Product(String name, int quantity, int buyingPrice, int sellingPrice, int spoilt) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.spoilt = spoilt;
        this.paymentStatus = paymentStatus;
        this.store_id = store_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getSpoilt() {
        return spoilt;
    }

    public void setSpoilt(int spoilt) {
        this.spoilt = spoilt;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", buyingPrice=" + buyingPrice +
                ", sellingPrice=" + sellingPrice +
                ", spoilt=" + spoilt +
                ", paymentStatus=" + paymentStatus +
                ", store_id=" + store_id +
                '}';
    }
}
