package com.solvd.newwearshop.impl;

import javax.xml.bind.JAXBException;

public interface Parsable<T> {

    T parse(String pathToXml) throws JAXBException;

}
