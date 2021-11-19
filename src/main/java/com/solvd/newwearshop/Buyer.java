package com.solvd.newwearshop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.newwearshop.impl.JaxbParser;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
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
    @XmlJavaTypeAdapter(value = JaxbParser.class)
    @JsonProperty("birthday")
    private LocalDateTime birthday;

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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}