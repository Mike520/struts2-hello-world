package com.mike520.struts2.helloworld.model;

/**
 * Created by liwenxiang on 2016/4/7.
 */
public class Product {
    public String name;
    public double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductAction{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {
        Product product = new Product("mouse", 12.3);
        System.out.println("product = " + product.toString());
    }
}
