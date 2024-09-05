package dev.ruchir.evolvion_sales_service.service.interfaces;

import dev.ruchir.evolvion_sales_service.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
    Optional<OrderDTO> getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    void deleteOrder(Long id);
}
