package com.solvd.newwearshop.impl;

import com.solvd.newwearshop.Buyer;
import com.solvd.newwearshop.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParsableImpl implements Parsable {

    @Override
    public Shop parse(String pathToXml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Shop.class, Buyer.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Shop) unmarshaller.unmarshal(new File(pathToXml));
    }
}
