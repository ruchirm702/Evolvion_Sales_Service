package dev.ruchir.evolvion_sales_service.dto;

import dev.ruchir.evolvion_sales_service.model.enums.OrderStatus;
import dev.ruchir.evolvion_sales_service.model.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private String orderNumber;
    private Long saleId; // Assuming you're storing the sale ID
    private Integer quantity;
    private Double price;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private Date createdAt;
    private Date updatedAt;
}