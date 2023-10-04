package com.ecommerce.msvcecommerce.repositories;

import com.ecommerce.msvcecommerce.models.entities.Price;
import com.ecommerce.msvcecommerce.utils.EcommerceConstants;
import com.ecommerce.msvcecommerce.utils.ErrorMessageTestCases;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PriceRepositoryTestCase {

    @Autowired
    PriceRepository repository;

    @DisplayName("Test: Get All Prices")
    @Test
    void testFindAllPrices_returnPrices() {
        // When
        Iterable<Price> listBD = repository.findAll();
        List<Price> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(4, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Get Prices By ProductId and BrandID")
    @Test
    void testFindPricesByProductIdAndBrandId_returnPrices() {
        Long productId = EcommerceConstants.PRODUCT_ID;
        Long brandId = EcommerceConstants.BRAND_ID;

        // When
        Iterable<Price> listBD = repository.findAllByBrandIdAndProductId(brandId, productId);
        List<Price> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(4, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Get Prices By BrandId and wrong product Id")
    @Test
    void testFindPricesByWrongProductIdAndBrandId_returnEmptyList() {
        Long productId = 45L;
        Long brandId = EcommerceConstants.BRAND_ID;

        // When
        Iterable<Price> listBD = repository.findAllByBrandIdAndProductId(brandId, productId);
        List<Price> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertTrue(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_EMPTY_LIST);
        });
    }
}
