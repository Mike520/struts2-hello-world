package com.mike520.struts2.helloworld.action;

import com.mike520.struts2.helloworld.model.Store;
import com.mike520.struts2.helloworld.service.StoreManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by liwenxiang on 2016/4/8.
 */
@Namespace("")
public class StoreAction extends ActionSupport {
    private Store store;

    private StoreManager storeManager;

    @Action(value = "store", results = {
            @Result(name = "success", location = "/WEB-INF/store.jsp")
    })
    public String getTheStore() {
        store = storeManager.getStore();
        return "success";
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    public static void main(String[] args) {
        StoreAction storeAction = new StoreAction();
        storeAction.store = new Store("mouse", 20);
        System.out.println("storeAction.getStore() = " + storeAction.getStore());
    }
}
