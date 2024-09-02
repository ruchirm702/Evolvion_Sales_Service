package dev.ruchir.evolvion_sales_service.dto;

import dev.ruchir.evolvion_sales_service.model.enums.CustomerPriority;
import dev.ruchir.evolvion_sales_service.model.enums.CustomerType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerRequirementDTO {
    private Long id;
    private String customerName;
    private String requirementDetails;
    private CustomerPriority priority;
    private CustomerType customerType;
    private Date date;
    private Date createdAt;
    private Date updatedAt;
}
