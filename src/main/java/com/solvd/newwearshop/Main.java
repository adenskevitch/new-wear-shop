package com.solvd.newwearshop;

import com.solvd.newwearshop.impl.DomParsableImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        DomParsableImpl domPars = new DomParsableImpl();
        Buyer buyer = domPars.parse("src/main/resources/buyerData.xml", "Vladimir");
        LOGGER.debug(buyer.toString());
    }
}
