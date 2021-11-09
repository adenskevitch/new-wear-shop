package com.solvd.newwearshop;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Parsable {

    Document parse() throws ParserConfigurationException, IOException, SAXException;

}
