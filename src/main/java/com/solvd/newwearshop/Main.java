package com.solvd.newwearshop;

import com.solvd.newwearshop.impl.DomParser;
import com.solvd.newwearshop.impl.JaxbParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws JAXBException {

        String XmlFilePath = "src/main/resources/buyerData.xml";

        //DOM realisation
        DomParser domPars = new DomParser();
        LOGGER.debug(domPars.parse(XmlFilePath));

        //JAXB realisation
        JaxbParser jaxbPars = new JaxbParser();
        LOGGER.debug(jaxbPars.parse(XmlFilePath));
    }
}
