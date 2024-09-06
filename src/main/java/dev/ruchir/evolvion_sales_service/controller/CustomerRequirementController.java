package dev.ruchir.evolvion_sales_service.controller;

import dev.ruchir.evolvion_sales_service.dto.CustomerRequirementDTO;
import dev.ruchir.evolvion_sales_service.service.interfaces.CustomerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer-requirements")
@Validated
public class CustomerRequirementController {

    private final CustomerRequirementService customerRequirementService;

    @Autowired
    public CustomerRequirementController(CustomerRequirementService customerRequirementService) {
        this.customerRequirementService = customerRequirementService;
    }

    @PostMapping
    public ResponseEntity<CustomerRequirementDTO> createCustomerRequirement(@Valid @RequestBody CustomerRequirementDTO customerRequirementDTO) {
        CustomerRequirementDTO createdCustomerRequirement = customerRequirementService.createCustomerRequirement(customerRequirementDTO);
        return ResponseEntity.ok(createdCustomerRequirement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerRequirementDTO> updateCustomerRequirement(@PathVariable Long id, @Valid @RequestBody CustomerRequirementDTO customerRequirementDTO) {
        CustomerRequirementDTO updatedCustomerRequirement = customerRequirementService.updateCustomerRequirement(id, customerRequirementDTO);
        return ResponseEntity.ok(updatedCustomerRequirement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRequirementDTO> getCustomerRequirementById(@PathVariable Long id) {
        return customerRequirementService.getCustomerRequirementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CustomerRequirementDTO>> getAllCustomerRequirements() {
        return ResponseEntity.ok(customerRequirementService.getAllCustomerRequirements());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerRequirement(@PathVariable Long id) {
        customerRequirementService.deleteCustomerRequirement(id);
        return ResponseEntity.noContent().build();
    }
}
