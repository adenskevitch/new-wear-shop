package com.solvd.newwearshop.impl;

import com.solvd.newwearshop.Buyer;

public interface Parsable {

    Buyer parse(String pathToXml, String firstName);

}
