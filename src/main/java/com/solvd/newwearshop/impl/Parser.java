package com.solvd.newwearshop.impl;

import javax.xml.bind.JAXBException;

public interface Parser<T> {

    T parse(String pathToXml) throws JAXBException;

}
