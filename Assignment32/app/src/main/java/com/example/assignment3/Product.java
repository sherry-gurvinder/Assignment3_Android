package com.example.assignment3;

public class Product {
    String name;
    double price;
    int img;

    public Product(String name, double price, int img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }
}