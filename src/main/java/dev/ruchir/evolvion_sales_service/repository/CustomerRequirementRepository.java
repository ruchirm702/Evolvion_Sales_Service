package dev.ruchir.evolvion_sales_service.repository;

import dev.ruchir.evolvion_sales_service.model.core.CustomerRequirement;
import dev.ruchir.evolvion_sales_service.model.enums.CustomerPriority;
import dev.ruchir.evolvion_sales_service.model.enums.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRequirementRepository extends JpaRepository<CustomerRequirement, Long> {

    // Find all customer requirements by customerName
    List<CustomerRequirement> findByCustomerName(String customerName);

    // Find CustomerRequirement by customerName and priority
    List<CustomerRequirement> findByCustomerNameAndPriority(String customerName, CustomerPriority priority);

    // Find CustomerRequirement by requirementDetails (partially matching)
    List<CustomerRequirement> findByRequirementDetailsContaining(String keyword);

    // Custom query example: Find all requirements with a certain type of customer
    List<CustomerRequirement> findByCustomerType(CustomerType customerType);
}
