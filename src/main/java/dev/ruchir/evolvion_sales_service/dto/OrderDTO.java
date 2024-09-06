package dev.ruchir.evolvion_sales_service.dto;

import dev.ruchir.evolvion_sales_service.model.enums.OrderStatus;
import dev.ruchir.evolvion_sales_service.model.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class OrderDTO {

    private Long id;

    @NotBlank(message = "Order number is required")
    private String orderNumber;

    @NotNull(message = "Sale ID is required")
    private Long saleId; // Assuming you're storing the sale ID

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Order status is required")
    private OrderStatus status;

    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    private Date createdAt;

    private Date updatedAt;
}
