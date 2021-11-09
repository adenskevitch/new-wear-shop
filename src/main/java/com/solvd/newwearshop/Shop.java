package com.solvd.newwearshop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Shop {

    private List<Buyer> buyers = new ArrayList<>();

    public List<Buyer> getBuyers() {
        return buyers;
    }

    @XmlElement(name = "buyer")
    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "buyers=" + buyers +
                '}';
    }
}
