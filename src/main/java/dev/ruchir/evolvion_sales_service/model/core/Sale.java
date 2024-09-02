package dev.ruchir.evolvion_sales_service.model.core;


import dev.ruchir.evolvion_sales_service.model.enums.DeliveryMethod;
import dev.ruchir.evolvion_sales_service.model.enums.DiscountType;
import dev.ruchir.evolvion_sales_service.model.enums.PaymentMethod;
import dev.ruchir.evolvion_sales_service.model.enums.SaleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale extends BaseEntity {

    private String saleNumber;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}