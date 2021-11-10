package com.solvd.newwearshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Buyer {

    private static final Logger LOGGER = LogManager.getLogger();

    private double money;
    private Map<String, Integer> sizes;

    public Buyer(Map<String, Integer> sizes, Double money) {
        this.sizes = sizes;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "money=" + money +
                ", sizes=" + sizes +
                '}';
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