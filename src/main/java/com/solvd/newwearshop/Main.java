package com.solvd.newwearshop;

import com.solvd.newwearshop.impl.DomParser;
import com.solvd.newwearshop.impl.JacksonParser;
import com.solvd.newwearshop.impl.JaxbParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        String XmlFilePath = "src/main/resources/buyerData.xml";
        String jsonFilePath = "src/main/resources/buyerData.json";

//        //DOM realisation
//        DomParser domPars = new DomParser();
//        LOGGER.debug(domPars.parse(XmlFilePath));

        //JAXB realisation
        JaxbParser jaxbPars = new JaxbParser();
        LOGGER.debug(jaxbPars.parse(XmlFilePath));

        //Jackson realisation
        JacksonParser jacksonParser = new JacksonParser();
        LOGGER.debug(jacksonParser.parse(jsonFilePath));
    }
}
