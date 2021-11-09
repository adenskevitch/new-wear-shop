package com.solvd.newwearshop.impl;

import com.solvd.newwearshop.Buyer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DomParsableImpl implements Parsable {

    private static final Logger LOGGER = LogManager.getLogger();

    private Document createDocument(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(path));
    }

    private NodeList createBuyersList(Document document) {
        return document.getElementsByTagName("buyer");
    }

    private Double getMoney(Node targetBuyer) {
        return Double.valueOf(targetBuyer.getFirstChild().getNextSibling().getTextContent());
    }

    private Map<String, Integer> getSizes(Node targetBuyer) {
        Map<String, Integer> sizes = new HashMap<>();
        NodeList nodeList = targetBuyer.getChildNodes();
        IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(buyerDataItem ->
                        "sizes".equals(buyerDataItem.getNodeName()))
                .map(Node::getChildNodes)
                .forEach(sizeList ->
                        IntStream.range(0, sizeList.getLength())
                                .filter(k ->
                                        sizeList.item(k).getNodeType() == Node.ELEMENT_NODE)
                                .mapToObj(k ->
                                        (Element) sizeList.item(k))
                                .forEach(e1 ->
                                        sizes.put(e1.getElementsByTagName("key").item(0).getTextContent(),
                                                Integer.parseInt(e1.getElementsByTagName("value").item(0).getTextContent()))));
        return sizes;
    }

    private List<Buyer> getBuyerData(NodeList buyerList) {
        return IntStream.range(0, buyerList.getLength())
                .mapToObj(buyerList::item)
                .map(targetBuyer ->
                        new Buyer(getSizes(targetBuyer), getMoney(targetBuyer)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Buyer> parse(String pathToXml) {
        Document document = null;
        try {
            document = createDocument(pathToXml);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.debug(e.getMessage());
        }
        NodeList buyerList = createBuyersList(document);
        return getBuyerData(buyerList);
    }
}
