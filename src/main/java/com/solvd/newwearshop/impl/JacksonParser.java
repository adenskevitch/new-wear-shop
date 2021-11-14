package com.solvd.newwearshop.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.newwearshop.Shop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser implements Parser {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Shop parse(String pathToJson) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.readValue(new File(pathToJson), Shop.class);
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
        return null;
    }
}
