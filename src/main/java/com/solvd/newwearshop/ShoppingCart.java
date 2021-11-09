package com.solvd.newwearshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    private static final Logger LOGGER = LogManager.getLogger();

    private double totalPrice;
    private List<Double> prices = new ArrayList<>();
    private Basket<Wear> wearBasket = new Basket<>();

    public void addWears(List<Wear> wears) {
        wearBasket.setProduct(wears);
        this.prices = wearBasket.getProduct().stream()
                .map(product -> product.getProductCost())
                .collect(Collectors.toList());
    }

    public void calculatedTotalPrice() {
        prices.forEach(price -> this.totalPrice += price);
    }

    public void printCheck() {
        LOGGER.debug("Date: " + LocalDateTime.now().toLocalDate());
        LOGGER.debug("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        wearBasket.getProduct().forEach(product -> LOGGER.debug(product.getProductType().getDescription() + " . ......" + product.getProductCost()));
        LOGGER.debug("Total...." + this.totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Basket<Wear> getWearBasket() {
        return wearBasket;
    }

    public void setWearBasket(Basket<Wear> wearBasket) {
        this.wearBasket = wearBasket;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }
}