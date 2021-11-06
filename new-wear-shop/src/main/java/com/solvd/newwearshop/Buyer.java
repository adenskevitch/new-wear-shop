package com.solvd.newwearshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Buyer {

    private static final Logger LOGGER = LogManager.getLogger();

    private double money;
    private Map<String, Integer> sizes;

    public Buyer(Map<String, Integer> sizes, double money) {
        this.sizes = sizes;
        this.money = money;
    }

    public boolean selectProduct(Product product) {
        boolean selected = false;
        if (ProductType.PANTS.equals(product.getProductType())) {
            selected = product.getProductCost() < 150;
        } else if (ProductType.OUTERWEAR.equals(product.getProductType())) {
            selected = product.getProductCost() < 300;
        } else if (ProductType.SHIRT.equals(product.getProductType())) {
            selected = product.getProductCost() < 100;
        }
        if (selected) {
            LOGGER.debug(product.getProductType().getDescription() + " was added.");
        }
        return selected;
    }

    public void buy(ShoppingCart shoppingCart) throws Exception {
        if (shoppingCart.getTotalPrice() > this.getMoney()) {
            throw new Exception("Not enough money...");
        } else {
            this.money = this.money - shoppingCart.getTotalPrice();
            LOGGER.debug("Balance at the moment " + new Date() + "....  " + this.getMoney());
            LOGGER.debug("Purchase made...");
        }
    }

    public double getMoney() {
        return money;
    }

    public Map<String, Integer> getSizes() {
        return sizes;
    }

    public void setSizes(Map<String, Integer> sizes) {
        this.sizes = sizes;
    }

    public void setMoney(double money) {
        this.money = this.money + money;
    }
}