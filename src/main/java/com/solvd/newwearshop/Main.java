package com.solvd.newwearshop;

import com.solvd.newwearshop.impl.DomParsableImpl;
import com.solvd.newwearshop.impl.JaxbParsableImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws JAXBException {

        String XmlFilePath = "src/main/resources/buyerData.xml";

        //DOM realisation
        DomParsableImpl domPars = new DomParsableImpl();
        LOGGER.debug(domPars.parse(XmlFilePath));

        //JAXB realisation
        JaxbParsableImpl jaxbPars = new JaxbParsableImpl();
        LOGGER.debug(jaxbPars.parse(XmlFilePath));
    }
}
