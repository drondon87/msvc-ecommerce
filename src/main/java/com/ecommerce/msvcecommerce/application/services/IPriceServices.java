package com.ecommerce.msvcecommerce.application.services;

import com.ecommerce.msvcecommerce.domain.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.domain.dtos.PriceRequestDTO;

import java.util.List;

public interface IPriceServices {

    /**
     *
     * @param priceRequestDTO
     * @return All Filter Prices
     */
    PriceDTO findProductsPrice(PriceRequestDTO priceRequestDTO);

    /**
     * @return All prices
     */
    List<PriceDTO> getAllPrices();
}
