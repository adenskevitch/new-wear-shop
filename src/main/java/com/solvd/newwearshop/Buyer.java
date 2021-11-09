package com.solvd.newwearshop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(namespace = "com.solvd.newwearshop.Shop")
public class Buyer {

    private double money;
    private Map<String, Integer> sizes;

    public Buyer(Map<String, Integer> sizes, Double money) {
        this.sizes = sizes;
        this.money = money;
    }

    public Buyer() {
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

    @XmlElement
    public void setSizes(Map<String, Integer> sizes) {
        this.sizes = sizes;
    }

    @XmlElement
    public void setMoney(double money) {
        this.money = this.money + money;
    }
}