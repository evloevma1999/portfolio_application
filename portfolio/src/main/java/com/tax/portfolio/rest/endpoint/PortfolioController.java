package com.tax.portfolio.rest.endpoint;

import com.tax.portfolio.rest.data.Client;
import com.tax.portfolio.rest.data.ClientRepository;
import com.tax.portfolio.rest.data.Portfolio;
import com.tax.portfolio.rest.data.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @PostMapping("/portfolio")
    public void addClient(@RequestBody CreatePortfolioRequest createPortfolio) {
        //extract portfolio from request
        Portfolio portfolio = new Portfolio();

        portfolioRepository.save(portfolio);
    }
}
