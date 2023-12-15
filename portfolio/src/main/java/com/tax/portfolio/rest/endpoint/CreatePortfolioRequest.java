package com.tax.portfolio.rest.endpoint;

import com.tax.portfolio.rest.data.PortfolioStock;

import java.util.ArrayList;

public class CreatePortfolioRequest {
    String name;
    String description;
    String countryCode;
    String provinceStateCode;
    Long timeHorizon;
    Long balance;
    String clientId;
    ArrayList<PortfolioStock> stocks;
}
