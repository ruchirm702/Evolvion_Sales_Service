package dev.ruchir.evolvion_sales_service.model.core;

import dev.ruchir.evolvion_sales_service.model.enums.OrderStatus;
import dev.ruchir.evolvion_sales_service.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    private Integer quantity;
    private Double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
