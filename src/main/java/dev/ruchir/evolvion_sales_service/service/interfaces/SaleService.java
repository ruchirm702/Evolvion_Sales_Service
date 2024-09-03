package dev.ruchir.evolvion_sales_service.service.interfaces;

import dev.ruchir.evolvion_sales_service.dto.SaleDTO;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    SaleDTO updateSale(Long id, SaleDTO saleDTO);
    Optional<SaleDTO> getSaleById(Long id);
    List<SaleDTO> getAllSales();
    void deleteSale(Long id);
}
