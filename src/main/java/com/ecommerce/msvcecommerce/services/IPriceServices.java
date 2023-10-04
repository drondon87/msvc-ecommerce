package com.ecommerce.msvcecommerce.services;

import com.ecommerce.msvcecommerce.models.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.models.dtos.PriceRequestDTO;

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
