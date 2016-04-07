package com.mike520.struts2.helloworld.action;

import com.mike520.struts2.helloworld.model.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by liwenxiang on 2016/4/7.
 */
public class ProductAction extends ActionSupport {
    private Product product;

    @Override
    public String execute() throws Exception {
        product = new Product("mouse", 12.3);
        return SUCCESS;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static void main(String[] args) {
        ProductAction productAction = new ProductAction();
        try {
            productAction.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("productAction.getProduct() = " + productAction.getProduct());
    }
}
