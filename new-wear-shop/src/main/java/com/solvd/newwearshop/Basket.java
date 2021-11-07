package com.solvd.newwearshop;

import java.util.List;

public class Basket<E extends Product> {

    private List<E> product;

    public List<E> getProduct() {
        return product;
    }

    public void setProduct(List<E> product) {
        this.product = product;
    }
}
