package com.ecommerce.msvcecommerce.services.impl;
import com.ecommerce.msvcecommerce.exception.PriceNotFoundException;
import com.ecommerce.msvcecommerce.models.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.models.dtos.PriceRequestDTO;
import com.ecommerce.msvcecommerce.models.entities.Price;
import com.ecommerce.msvcecommerce.models.mapper.PriceMapper;
import com.ecommerce.msvcecommerce.repositories.PriceRepository;
import com.ecommerce.msvcecommerce.services.IPriceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PriceServiceImpl implements IPriceServices {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public PriceDTO findProductsPrice(PriceRequestDTO priceRequestDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime petitionDate = LocalDateTime.parse(priceRequestDTO.getPetitionDate(), formatter);
        List<Price> pricesDB = priceRepository.findAllByBrandIdAndProductId(Long.parseLong(priceRequestDTO.getBrandId()), Long.parseLong(priceRequestDTO.getProductId()));
        Price pricesFiltered = pricesDB.stream()
                .filter(price -> petitionDate.isAfter(price.getStartDate()) && petitionDate.isBefore(price.getEndDate()))
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> {
                    throw new PriceNotFoundException("Price not found with the given input data");
                });
        return PriceMapper.mapToPriceDTO(pricesFiltered,new PriceDTO());
    }

    /**
     * @return All prices
     */
    @Override
    public List<PriceDTO> getAllPrices() {
        return transforListDTOPrices(priceRepository.findAll());
    }

    /**
     * @param prices list from the Repository
     * @return Prices List transform on DTO
     */
    private List<PriceDTO> transforListDTOPrices(List<Price> prices){
        List<PriceDTO> pricesDtos = new ArrayList<>();
        prices.forEach(p ->  pricesDtos.add(PriceMapper.mapToPriceDTO(p,new PriceDTO())));
        return pricesDtos;
    }
}
