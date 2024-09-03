package dev.ruchir.evolvion_sales_service.service.impl;

import dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions.SaleCreationException;
import dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions.SaleNotFoundException;
import dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions.SaleUpdateException;
import dev.ruchir.evolvion_sales_service.dto.SaleDTO;
import dev.ruchir.evolvion_sales_service.mapper.SaleMapper;
import dev.ruchir.evolvion_sales_service.model.core.Sale;
import dev.ruchir.evolvion_sales_service.repository.SaleRepository;
import dev.ruchir.evolvion_sales_service.service.interfaces.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        try {
            Sale sale = saleMapper.toEntity(saleDTO);
            Sale savedSale = saleRepository.save(sale);
            return saleMapper.toDTO(savedSale);
        } catch (Exception e) {
            throw new SaleCreationException("Failed to create sale", e);
        }
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        try {
            if (!saleRepository.existsById(id)) {
                throw new SaleNotFoundException("Sale not found with ID: " + id);
            }
            Sale sale = saleMapper.toEntity(saleDTO);
            sale.setId(id);
            Sale updatedSale = saleRepository.save(sale);
            return saleMapper.toDTO(updatedSale);
        } catch (Exception e) {
            throw new SaleUpdateException("Failed to update sale", e);
        }
    }

    @Override
    public Optional<SaleDTO> getSaleById(Long id) {
        return saleRepository.findById(id).map(saleMapper::toDTO);
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleMapper.toDTOs(saleRepository.findAll());
    }

    @Override
    public void deleteSale(Long id) {
        if (!saleRepository.existsById(id)) {
            throw new SaleNotFoundException("Sale not found with ID: " + id);
        }
        saleRepository.deleteById(id);
    }
}
