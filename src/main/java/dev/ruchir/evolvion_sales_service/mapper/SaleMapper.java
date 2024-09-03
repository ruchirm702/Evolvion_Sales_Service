package dev.ruchir.evolvion_sales_service.mapper;


import dev.ruchir.evolvion_sales_service.dto.SaleDTO;
import dev.ruchir.evolvion_sales_service.model.core.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);
    SaleDTO toDTO(Sale sale);
    Sale toEntity(SaleDTO saleDTO);
    List<SaleDTO> toDTOs(List<Sale> sales);
    List<Sale> toEntities(List<SaleDTO> saleDTOs);
}
