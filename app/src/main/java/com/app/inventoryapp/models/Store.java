package com.app.inventoryapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;

public class Store {
    private int id;
    private String name;
    private String location;
    private ArrayList<Product> products;
    private ArrayList<Attendant> attendants;

    public Store(String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.products = products;
        this.attendants = attendants;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Attendant> getAttendants() {
        return attendants;
    }

    public void setAttendants(ArrayList<Attendant> attendants) {
        this.attendants = attendants;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", products=" + products +
                ", attendants=" + attendants +
                '}';
    }
}
