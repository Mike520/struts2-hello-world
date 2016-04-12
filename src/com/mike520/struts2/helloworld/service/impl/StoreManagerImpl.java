package com.mike520.struts2.helloworld.service.impl;

import com.mike520.struts2.helloworld.model.Store;
import com.mike520.struts2.helloworld.service.StoreManager;

/**
 * Created by liwenxiang on 2016/4/12.
 */
public class StoreManagerImpl implements StoreManager {
    @Override
    public Store getStore() {
        Store store = new Store("mouse", 20);
        return store;
    }

    public static void main(String[] args) {
        StoreManagerImpl storeManager = new StoreManagerImpl();
        Store store = storeManager.getStore();
        System.out.println("store = " + store);
    }
}
