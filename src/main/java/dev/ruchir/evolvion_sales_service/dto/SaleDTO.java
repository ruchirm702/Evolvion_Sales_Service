package dev.ruchir.evolvion_sales_service.dto;

import dev.ruchir.evolvion_sales_service.model.enums.DeliveryMethod;
import dev.ruchir.evolvion_sales_service.model.enums.DiscountType;
import dev.ruchir.evolvion_sales_service.model.enums.PaymentMethod;
import dev.ruchir.evolvion_sales_service.model.enums.SaleStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class SaleDTO {

    private Long id;

    @NotBlank(message = "Sale number is required")
    private String saleNumber;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotNull(message = "Sale status is required")
    private SaleStatus status;

    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    private DiscountType discountType;

    @NotNull(message = "Delivery method is required")
    private DeliveryMethod deliveryMethod;

    @NotNull(message = "Sale date is required")
    @PastOrPresent(message = "Sale date cannot be in the future")
    private Date date;

    private Date createdAt;

    private Date updatedAt;
}
