package dev.ruchir.evolvion_sales_service.dto;

import dev.ruchir.evolvion_sales_service.model.enums.CustomerPriority;
import dev.ruchir.evolvion_sales_service.model.enums.CustomerType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class CustomerRequirementDTO {

    private Long id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Requirement details are required")
    @Size(max = 500, message = "Requirement details cannot exceed 500 characters")
    private String requirementDetails;

    @NotNull(message = "Customer priority is required")
    private CustomerPriority priority;

    @NotNull(message = "Customer type is required")
    private CustomerType customerType;

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Date cannot be in the future")
    private Date date;

    private Date createdAt;

    private Date updatedAt;
}
