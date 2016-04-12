package com.mike520.struts2.helloworld.service.impl;

import com.mike520.struts2.helloworld.model.Product;
import com.mike520.struts2.helloworld.service.ProductManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwenxiang on 2016/4/12.
 */
public class ProductManagerImpl implements ProductManager {
    @Override
    public List<Product> getProducts() {
        Product product = null;
        List<Product> productList = null;
        if (productList == null) {
            productList = new ArrayList<Product>();
        }
        for (int i = 0; i < 5; i++) {
            product = new Product("mouse"+i, (12.345+i));
            productList.add(product);
        }
        return productList;
    }

    public static void main(String[] args) {
        ProductManagerImpl productManager = new ProductManagerImpl();
        List<Product> products = productManager.getProducts();
        System.out.println("products = " + products);
    }
}
