package com.mike520.struts2.helloworld.model;

/**
 * Created by liwenxiang on 2016/4/8.
 */
public class Store {
    public String name;
    public int number;

    public Store(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public static void main(String[] args) {
        Store store = new Store("mouse", 12);
        System.out.println("store = " + store);
    }
}
