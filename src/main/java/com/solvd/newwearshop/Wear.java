package com.solvd.newwearshop;

import com.solvd.newwearshop.parameters.FabricParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Wear extends Product {

    private static final Logger LOGGER = LogManager.getLogger();

    private FabricParameter fabric;

    public Wear(ProductType productName, FabricParameter fabric) {
        super(productName);
        this.fabric = fabric;
    }

    public FabricParameter getFabric() {
        return fabric;
    }

    public void setFabric(FabricParameter fabric) {
        this.fabric = fabric;
    }
}