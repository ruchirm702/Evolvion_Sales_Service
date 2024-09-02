package dev.ruchir.evolvion_sales_service.model.core;

import dev.ruchir.evolvion_sales_service.model.enums.CustomerPriority;
import dev.ruchir.evolvion_sales_service.model.enums.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "customer_requirements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequirement extends BaseEntity {

    private String customerName;
    private String requirementDetails;

    @Enumerated(EnumType.STRING)
    private CustomerPriority priority;

    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}