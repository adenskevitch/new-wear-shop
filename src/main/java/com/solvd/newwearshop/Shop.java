package com.solvd.newwearshop;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Shop {

    @XmlElement(name = "buyer")
    private List<Buyer> buyers = new ArrayList<>();

    public List<Buyer> getBuyers() {
        return buyers;
    }

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
