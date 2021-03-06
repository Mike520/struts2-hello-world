package com.mike520.struts2.helloworld.action;

import com.mike520.struts2.helloworld.model.Product;
import com.mike520.struts2.helloworld.service.ProductManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwenxiang on 2016/4/7.
 */
@Namespace("")
@Results({
        @Result(name = "success", location = "/WEB-INF/product.jsp")
})
public class ProductAction extends ActionSupport {
    private Product product;
    private List<Product> productList;

    private ProductManager productManager;

    @Action(value = "product")
    public String getTheProduct() {
        productList = productManager.getProducts();
        product = productList.get(0);
        return "success";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public static void main(String[] args) {
        ProductAction productAction = new ProductAction();
        if (productAction.productList == null) {
            productAction.productList = new ArrayList<Product>();
        }
        for (int i = 0; i < 5; i++) {
            productAction.product = new Product("mouse"+i, (12.345+i));
            productAction.productList.add(productAction.product);
        }
        System.out.println("productAction.getProduct() = " + productAction.getProduct());
        System.out.println("productAction.getProductList() = " + productAction.getProductList());
    }
}
