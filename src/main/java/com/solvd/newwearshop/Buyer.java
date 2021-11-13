package com.solvd.newwearshop;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(namespace = "com.solvd.newwearshop.Shop")
@XmlType(name = "buyer", propOrder = {"money", "sizes"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer {

    @XmlElement(name = "money")
    private double money;
    @XmlElement(name = "sizes")
    private Map<String, Integer> sizes;
    @XmlAttribute(name = "firstName")
    private String firstName;

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
                ", firstName='" + firstName + '\'' +
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}