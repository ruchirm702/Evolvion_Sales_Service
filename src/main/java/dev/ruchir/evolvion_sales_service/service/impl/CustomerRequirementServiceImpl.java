package dev.ruchir.evolvion_sales_service.service.impl;

import dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions.CustomerRequirementCreationException;
import dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions.CustomerRequirementNotFoundException;
import dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions.CustomerRequirementUpdateException;
import dev.ruchir.evolvion_sales_service.dto.CustomerRequirementDTO;
import dev.ruchir.evolvion_sales_service.mapper.CustomerRequirementMapper;
import dev.ruchir.evolvion_sales_service.model.core.CustomerRequirement;
import dev.ruchir.evolvion_sales_service.repository.CustomerRequirementRepository;
import dev.ruchir.evolvion_sales_service.service.interfaces.CustomerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerRequirementServiceImpl implements CustomerRequirementService {

    private final CustomerRequirementRepository customerRequirementRepository;
    private final CustomerRequirementMapper customerRequirementMapper;

    @Autowired
    public CustomerRequirementServiceImpl(CustomerRequirementRepository customerRequirementRepository, CustomerRequirementMapper customerRequirementMapper) {
        this.customerRequirementRepository = customerRequirementRepository;
        this.customerRequirementMapper = customerRequirementMapper;
    }

    @Override
    public CustomerRequirementDTO createCustomerRequirement(CustomerRequirementDTO customerRequirementDTO) {
        try {
            CustomerRequirement customerRequirement = customerRequirementMapper.toEntity(customerRequirementDTO);
            CustomerRequirement savedCustomerRequirement = customerRequirementRepository.save(customerRequirement);
            return customerRequirementMapper.toDTO(savedCustomerRequirement);
        } catch (Exception e) {
            // Logging exception might be helpful here
            throw new CustomerRequirementCreationException("Failed to create customer requirement", e);
        }
    }

    @Override
    public CustomerRequirementDTO updateCustomerRequirement(Long id, CustomerRequirementDTO customerRequirementDTO) {
        try {
            if (!customerRequirementRepository.existsById(id)) {
                throw new CustomerRequirementNotFoundException("Customer requirement not found with ID: " + id);
            }
            CustomerRequirement customerRequirement = customerRequirementMapper.toEntity(customerRequirementDTO);
            customerRequirement.setId(id);
            CustomerRequirement updatedCustomerRequirement = customerRequirementRepository.save(customerRequirement);
            return customerRequirementMapper.toDTO(updatedCustomerRequirement);
        } catch (Exception e) {
            // Logging exception might be helpful here
            throw new CustomerRequirementUpdateException("Failed to update customer requirement", e);
        }
    }

    @Override
    public Optional<CustomerRequirementDTO> getCustomerRequirementById(Long id) {
        return customerRequirementRepository.findById(id).map(customerRequirementMapper::toDTO);
    }

    @Override
    public List<CustomerRequirementDTO> getAllCustomerRequirements() {
        return customerRequirementMapper.toDTOs(customerRequirementRepository.findAll());
    }

    @Override
    public void deleteCustomerRequirement(Long id) {
        if (!customerRequirementRepository.existsById(id)) {
            throw new CustomerRequirementNotFoundException("Customer requirement not found with ID: " + id);
        }
        customerRequirementRepository.deleteById(id);
    }
}
