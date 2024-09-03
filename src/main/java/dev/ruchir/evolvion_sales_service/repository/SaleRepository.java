package dev.ruchir.evolvion_sales_service.repository;

import dev.ruchir.evolvion_sales_service.model.core.Sale;
import dev.ruchir.evolvion_sales_service.model.enums.SaleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    // Find Sale by saleNumber (assumes it is unique)
    Optional<Sale> findBySaleNumber(String saleNumber);

    // Custom query example: Find all sales with a certain status
    List<Sale> findByStatus(SaleStatus status);
}