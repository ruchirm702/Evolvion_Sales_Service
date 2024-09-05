package dev.ruchir.evolvion_sales_service.service.interfaces;

import dev.ruchir.evolvion_sales_service.dto.CustomerRequirementDTO;
import java.util.List;
import java.util.Optional;

public interface CustomerRequirementService {
    CustomerRequirementDTO createCustomerRequirement(CustomerRequirementDTO customerRequirementDTO);
    CustomerRequirementDTO updateCustomerRequirement(Long id, CustomerRequirementDTO customerRequirementDTO);
    Optional<CustomerRequirementDTO> getCustomerRequirementById(Long id);
    List<CustomerRequirementDTO> getAllCustomerRequirements();
    void deleteCustomerRequirement(Long id);
}
