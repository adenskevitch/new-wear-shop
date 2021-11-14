package com.solvd.newwearshop.impl;

import com.solvd.newwearshop.Buyer;
import com.solvd.newwearshop.Shop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.File;
import java.time.LocalDateTime;

public class JaxbParser extends XmlAdapter<String, LocalDateTime> implements Parser {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public LocalDateTime unmarshal(String date) throws Exception {
        return LocalDateTime.parse(date);
    }

    @Override
    public String marshal(LocalDateTime date) throws Exception {
        return date.toString();
    }

    @Override
    public Shop parse(String pathToXml) {
        JAXBContext context;
        Unmarshaller unmarshaller;
        try {
            context = JAXBContext.newInstance(Shop.class, Buyer.class);
            unmarshaller = context.createUnmarshaller();
            return (Shop) unmarshaller.unmarshal(new File(pathToXml));
        } catch (JAXBException e) {
            LOGGER.debug(e.getMessage());
        }
        return null;
    }
}
