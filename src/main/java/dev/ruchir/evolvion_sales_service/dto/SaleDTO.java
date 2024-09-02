package dev.ruchir.evolvion_sales_service.dto;

import dev.ruchir.evolvion_sales_service.model.enums.DeliveryMethod;
import dev.ruchir.evolvion_sales_service.model.enums.DiscountType;
import dev.ruchir.evolvion_sales_service.model.enums.PaymentMethod;
import dev.ruchir.evolvion_sales_service.model.enums.SaleStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SaleDTO {
    private Long id;
    private String saleNumber;
    private Double amount;
    private SaleStatus status;
    private PaymentMethod paymentMethod;
    private DiscountType discountType;
    private DeliveryMethod deliveryMethod;
    private Date date;
    private Date createdAt;
    private Date updatedAt;
}
