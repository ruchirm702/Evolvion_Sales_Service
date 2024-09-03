package dev.ruchir.evolvion_sales_service.repository;

import dev.ruchir.evolvion_sales_service.model.core.Order;
import dev.ruchir.evolvion_sales_service.model.core.Sale;
import dev.ruchir.evolvion_sales_service.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Find all orders by a specific sale
    List<Order> findBySale(Sale sale);

    // Find Order by orderNumber (assumes it is unique)
    Optional<Order> findByOrderNumber(String orderNumber);

    // Custom query example: Find all orders with a certain status
    List<Order> findByStatus(OrderStatus status);
}