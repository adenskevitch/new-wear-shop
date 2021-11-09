package com.solvd.newwearshop;

import com.solvd.newwearshop.parameters.Color;
import com.solvd.newwearshop.parameters.Fabric;
import com.solvd.newwearshop.parameters.FabricParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        ParsableImpl parser = new ParsableImpl();
        Map<String, Integer> sizes = new HashMap<>();
        double money = 0.0;

        try {
            NodeList buyerList = parser.parse().getElementsByTagName("buyer");
            for (int i = 0; i < buyerList.getLength(); i++) {
                Node buyerItem = buyerList.item(i);
                if ("Vladimir".equals(buyerItem.getAttributes().getNamedItem("firstName").getNodeValue())) {
                    NodeList buyerDataList = buyerItem.getChildNodes();
                    for (int j = 0; j < buyerDataList.getLength(); j++) {
                        Node buyerDataItem = buyerDataList.item(j);
                        switch (buyerDataItem.getNodeName()) {
                            case "money": {
                                money = Double.parseDouble(buyerDataItem.getTextContent());
                            }
                            break;
                            case "sizes": {
                                NodeList sizeList = buyerDataItem.getChildNodes();
                                IntStream.range(0, sizeList.getLength())
                                        .filter(k -> sizeList.item(k).getNodeType() == Node.ELEMENT_NODE)
                                        .mapToObj(k -> (Element) sizeList.item(k))
                                        .forEach(e1 -> sizes.put(e1.getElementsByTagName("param").item(0).getTextContent(), Integer.parseInt(e1.getElementsByTagName("paramValue").item(0).getTextContent())));
                            }
                            break;
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException |
                SAXException e) {
            LOGGER.debug(e.getMessage());
        }
        Buyer buyer = new Buyer(sizes, money);

        FabricParameter pantsFabric = new FabricParameter(Color.BLUE, Fabric.JEANS, buyer);
        FabricParameter outerwearFabric = new FabricParameter(Color.BROWN, Fabric.LEATHER, buyer);
        FabricParameter shirtFabric = new FabricParameter(Color.GREEN, Fabric.COTTON, buyer);

        Wear pants = new Wear(ProductType.PANTS, pantsFabric);
        Wear outerwear = new Wear(ProductType.OUTERWEAR, outerwearFabric);
        Wear shirt = new Wear(ProductType.SHIRT, shirtFabric);
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
        } catch (
                Exception e) {
            LOGGER.debug(e.getMessage());
        } finally {
            LOGGER.debug("Operation is completed");
        }
        shoppingCart.printCheck();
    }
}
