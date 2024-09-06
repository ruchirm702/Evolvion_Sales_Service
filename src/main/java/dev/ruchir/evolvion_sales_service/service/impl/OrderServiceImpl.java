package dev.ruchir.evolvion_sales_service.service.impl;

import dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions.OrderCreationException;
import dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions.OrderNotFoundException;
import dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions.OrderUpdateException;
import dev.ruchir.evolvion_sales_service.dto.OrderDTO;
import dev.ruchir.evolvion_sales_service.mapper.OrderMapper;
import dev.ruchir.evolvion_sales_service.model.core.Order;
import dev.ruchir.evolvion_sales_service.repository.OrderRepository;
import dev.ruchir.evolvion_sales_service.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        try {
            Order order = orderMapper.toEntity(orderDTO);
            Order savedOrder = orderRepository.save(order);
            return orderMapper.toDTO(savedOrder);
        } catch (Exception e) {
            // Logging exception might be helpful here
            throw new OrderCreationException("Failed to create order", e);
        }
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        try {
            if (!orderRepository.existsById(id)) {
                throw new OrderNotFoundException("Order not found with ID: " + id);
            }
            Order order = orderMapper.toEntity(orderDTO);
            order.setId(id);
            Order updatedOrder = orderRepository.save(order);
            return orderMapper.toDTO(updatedOrder);
        } catch (Exception e) {
            // Logging exception might be helpful here
            throw new OrderUpdateException("Failed to update order", e);
        }
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDTO);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderMapper.toDTOs(orderRepository.findAll());
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found with ID: " + id);
        }
        orderRepository.deleteById(id);
    }
}
