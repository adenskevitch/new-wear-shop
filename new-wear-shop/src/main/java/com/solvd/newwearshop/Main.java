package com.solvd.newwearshop;

import com.solvd.newwearshop.parameters.Color;
import com.solvd.newwearshop.parameters.Fabric;
import com.solvd.newwearshop.parameters.FabricParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Map<String, Integer> sizes = new HashMap<>();
        sizes.put("height", 170);
        sizes.put("chest", 80);
        sizes.put("waist", 50);
        Buyer buyer = new Buyer(sizes, 600.00);

        FabricParameter pantsFabric = new FabricParameter(Color.BLUE, Fabric.JEANS,buyer);
        FabricParameter outerwearFabric = new FabricParameter(Color.BROWN, Fabric.LEATHER,buyer);
        FabricParameter shirtFabric = new FabricParameter(Color.GREEN, Fabric.COTTON,buyer);

        Wear pants = new Wear(ProductType.PANTS,  pantsFabric);
        Wear outerwear = new Wear(ProductType.OUTERWEAR,  outerwearFabric);
        Wear shirt = new Wear(ProductType.SHIRT,  shirtFabric);
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Wear> wears = new ArrayList<>();
        if (buyer.selectProduct(pants)) {
            wears.add(pants);
        }
        if (buyer.selectProduct(outerwear)) {
            wears.add(outerwear);
        }
        if (buyer.selectProduct(shirt)) {
            wears.add(shirt);
        }
        shoppingCart.addWears(wears);
        shoppingCart.calculatedTotalPrice();
        try {
            buyer.buy(shoppingCart);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        } finally {
            LOGGER.debug("Operation is completed");
        }
        shoppingCart.printCheck();
    }
}
