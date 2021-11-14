package com.solvd.newwearshop;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(namespace = "com.solvd.newwearshop.Shop")
@XmlType(name = "buyer", propOrder = {"birthday", "money", "sizes"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer {

    @XmlElement(name = "money")
    @JsonProperty("money")
    private double money;
    @XmlElement(name = "sizes")
    @JsonProperty("sizes")
    private Map<String, Integer> sizes;
    @XmlAttribute(name = "firstName")
    @JsonProperty("firstName")
    private String firstName;
    @XmlElement(name = "birthday")
    @JsonProperty("birthday")
    private Date birthday;

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
                ", birthday=" + birthday +
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}