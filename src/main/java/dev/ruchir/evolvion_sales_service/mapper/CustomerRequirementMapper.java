package dev.ruchir.evolvion_sales_service.mapper;

import dev.ruchir.evolvion_sales_service.dto.CustomerRequirementDTO;
import dev.ruchir.evolvion_sales_service.model.core.CustomerRequirement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerRequirementMapper {

    CustomerRequirementMapper INSTANCE = Mappers.getMapper(CustomerRequirementMapper.class);
    CustomerRequirementDTO toDTO(CustomerRequirement customerRequirement);
    CustomerRequirement toEntity(CustomerRequirementDTO customerRequirementDTO);
    List<CustomerRequirementDTO> toDTOs(List<CustomerRequirement> customerRequirements);
    List<CustomerRequirement> toEntities(List<CustomerRequirementDTO> customerRequirementDTOs);
}

