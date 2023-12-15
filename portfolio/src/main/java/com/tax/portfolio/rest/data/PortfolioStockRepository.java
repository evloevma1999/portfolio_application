package com.tax.portfolio.rest.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioStockRepository extends JpaRepository<PortfolioStock, Long> {
    Client findByPortfolioId(String portfolioId);
}
