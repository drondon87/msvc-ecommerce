package com.ecommerce.msvcecommerce.infraestructure.mapper;

import com.ecommerce.msvcecommerce.domain.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.infraestructure.entities.Price;

import java.time.format.DateTimeFormatter;

public class PriceMapper {

    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static PriceDTO mapToPriceDTO(Price price, PriceDTO priceDTO){
        String priceFormat = price.getPrice().toString() + " " + price.getCurr();
        priceDTO.setPrice(priceFormat);
        priceDTO.setFinalPrice(priceFormat);
        priceDTO.setBrandId(price.getBrandId());
        priceDTO.setProductId(price.getProductId());

        String startDateFormatted = price.getStartDate().format(formatter);
        String endDateFormatted = price.getEndDate().format(formatter);

        priceDTO.setApplicationDate(startDateFormatted + " - " + endDateFormatted);
        return priceDTO;
    }
}
