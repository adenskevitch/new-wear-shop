package com.solvd.newwearshop;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlType(name = "shop", propOrder = {"today", "buyers"})
public class Shop {

    @XmlElement(name = "today")
    @JsonProperty("today")
    private Date today;
    @XmlElement(name = "buyer")
    @JsonProperty("buyers")
    private List<Buyer> buyers = new ArrayList<>();

    @Override
    public String toString() {
        return "Shop{" +
                "today=" + today +
                ", buyers=" + buyers +
                '}';
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public Date getTodayDay() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
}
