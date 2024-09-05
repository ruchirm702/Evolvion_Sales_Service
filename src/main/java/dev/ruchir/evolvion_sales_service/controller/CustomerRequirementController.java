package dev.ruchir.evolvion_sales_service.controller;

import dev.ruchir.evolvion_sales_service.dto.CustomerRequirementDTO;
import dev.ruchir.evolvion_sales_service.service.interfaces.CustomerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer-requirements")
public class CustomerRequirementController {

    private final CustomerRequirementService customerRequirementService;

    @Autowired
    public CustomerRequirementController(CustomerRequirementService customerRequirementService) {
        this.customerRequirementService = customerRequirementService;
    }

    @PostMapping
    public ResponseEntity<CustomerRequirementDTO> createCustomerRequirement(@RequestBody CustomerRequirementDTO customerRequirementDTO) {
        CustomerRequirementDTO createdCustomerRequirement = customerRequirementService.createCustomerRequirement(customerRequirementDTO);
        return ResponseEntity.ok(createdCustomerRequirement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerRequirementDTO> updateCustomerRequirement(@PathVariable Long id, @RequestBody CustomerRequirementDTO customerRequirementDTO) {
        CustomerRequirementDTO updatedCustomerRequirement = customerRequirementService.updateCustomerRequirement(id, customerRequirementDTO);
        return ResponseEntity.ok(updatedCustomerRequirement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerRequirementDTO>> getCustomerRequirementById(@PathVariable Long id) {
        Optional<CustomerRequirementDTO> customerRequirementDTO = customerRequirementService.getCustomerRequirementById(id);
        return ResponseEntity.ok(customerRequirementDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerRequirementDTO>> getAllCustomerRequirements() {
        List<CustomerRequirementDTO> customerRequirements = customerRequirementService.getAllCustomerRequirements();
        return ResponseEntity.ok(customerRequirements);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerRequirement(@PathVariable Long id) {
        customerRequirementService.deleteCustomerRequirement(id);
        return ResponseEntity.noContent().build();
    }
}
