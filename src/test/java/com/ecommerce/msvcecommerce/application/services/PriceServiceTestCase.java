package com.ecommerce.msvcecommerce.application.services;

import com.ecommerce.msvcecommerce.application.services.IPriceServices;
import com.ecommerce.msvcecommerce.domain.port.data.EcommerceData;
import com.ecommerce.msvcecommerce.domain.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.domain.dtos.PriceRequestDTO;
import com.ecommerce.msvcecommerce.infraestructure.entities.Price;
import com.ecommerce.msvcecommerce.domain.port.repositories.PriceRepository;
import com.ecommerce.msvcecommerce.infraestructure.utils.EcommerceConstants;
import com.ecommerce.msvcecommerce.utils.ErrorMessageTestCases;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class PriceServiceTestCase {

	@MockBean
	PriceRepository repository;

	@Autowired
	IPriceServices service;

	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@DisplayName("Test: Get All Prices")
	@Test
	void testGetAllPrices_returnPrices() {

		// Given
		List<Price> listMockBD = Arrays.asList(EcommerceData.getPrice01(), EcommerceData.getPrice02(), EcommerceData.getPrice03(), EcommerceData.getPrice04());
		when(repository.findAll()).thenReturn(listMockBD);

		// When
		List<PriceDTO> expectedList = service.getAllPrices();

		assertAll(() -> {
			assertEquals(4, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
		}, () -> {
			assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
		}, () -> {
			assertTrue(expectedList.contains(EcommerceData.getPriceDto03()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
		}, () -> {
			verify(repository, times(1)).findAll();
		});
	}

	/**
	 * Test1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@DisplayName("Test: Get Price Test 1")
	@Test
	void testGeTPriceTest1_returnPrice(){

		// Params
		Long productId = EcommerceConstants.PRODUCT_ID;
		Long brandId = EcommerceConstants.BRAND_ID;

		PriceRequestDTO priceRequestDTO = new PriceRequestDTO("2020-06-14 10:00:00", productId.toString(), brandId.toString());

		List<Price> listMockBD = Arrays.asList(EcommerceData.getPrice01(), EcommerceData.getPrice02(), EcommerceData.getPrice03(), EcommerceData.getPrice04());

		// Given
		when(repository.findAllByBrandIdAndProductId(brandId,productId)).thenReturn(listMockBD);

		// When
		PriceDTO expectedPrice = service.findProductsPrice(priceRequestDTO);

		assertAll(() -> {
			assertNotNull(expectedPrice, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
		}, () -> {
			assertEquals(expectedPrice, EcommerceData.getPriceExpectedTest01(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_PRICE);
		},
		() -> {
			verify(repository, times(1)).findAllByBrandIdAndProductId(brandId, productId);
		});
	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@DisplayName("Test: Get Price Test 2")
	@Test
	void testGeTPriceTest2_returnPrice(){

		// Params
		Long productId = EcommerceConstants.PRODUCT_ID;
		Long brandId = EcommerceConstants.BRAND_ID;

		PriceRequestDTO priceRequestDTO = new PriceRequestDTO("2020-06-14 16:00:00", productId.toString(), brandId.toString());

		List<Price> listMockBD = Arrays.asList(EcommerceData.getPrice01(), EcommerceData.getPrice02(), EcommerceData.getPrice03(), EcommerceData.getPrice04());

		// Given
		when(repository.findAllByBrandIdAndProductId(brandId,productId)).thenReturn(listMockBD);

		// When
		PriceDTO expectedPrice = service.findProductsPrice(priceRequestDTO);

		assertAll(() -> {
			assertNotNull(expectedPrice, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
		}, () -> {
			assertEquals(expectedPrice, EcommerceData.getPriceExpectedTest02(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_PRICE);
		},
		() -> {
			verify(repository, times(1)).findAllByBrandIdAndProductId(brandId, productId);
		});
	}

	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@DisplayName("Test: Get Price Test 3")
	@Test
	void testGeTPriceTest3_returnPrice(){

		// Params
		Long productId = EcommerceConstants.PRODUCT_ID;
		Long brandId = EcommerceConstants.BRAND_ID;

		PriceRequestDTO priceRequestDTO = new PriceRequestDTO("2020-06-14 21:00:00", productId.toString(), brandId.toString());

		List<Price> listMockBD = Arrays.asList(EcommerceData.getPrice01(), EcommerceData.getPrice02(), EcommerceData.getPrice03(), EcommerceData.getPrice04());

		// Given
		when(repository.findAllByBrandIdAndProductId(brandId,productId)).thenReturn(listMockBD);

		// When
		PriceDTO expectedPrice = service.findProductsPrice(priceRequestDTO);

		assertAll(() -> {
			assertNotNull(expectedPrice, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
		}, () -> {
			assertEquals(expectedPrice, EcommerceData.getPriceExpectedTest01(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_PRICE);
		},
		() -> {
			verify(repository, times(1)).findAllByBrandIdAndProductId(brandId, productId);
		});
	}

	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 */
	@DisplayName("Test: Get Price Test 4")
	@Test
	void testGeTPriceTest4_returnPrice(){

		// Params
		Long productId = EcommerceConstants.PRODUCT_ID;
		Long brandId = EcommerceConstants.BRAND_ID;

		PriceRequestDTO priceRequestDTO = new PriceRequestDTO("2020-06-15 10:00:00", productId.toString(), brandId.toString());

		List<Price> listMockBD = Arrays.asList(EcommerceData.getPrice01(), EcommerceData.getPrice02(), EcommerceData.getPrice03(), EcommerceData.getPrice04());

		// Given
		when(repository.findAllByBrandIdAndProductId(brandId,productId)).thenReturn(listMockBD);

		// When
		PriceDTO expectedPrice = service.findProductsPrice(priceRequestDTO);

		assertAll(() -> {
			assertNotNull(expectedPrice, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
		}, () -> {
			assertEquals(expectedPrice, EcommerceData.getPriceExpectedTest04(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_PRICE);
		},
		() -> {
			verify(repository, times(1)).findAllByBrandIdAndProductId(brandId, productId);
		});
	}

	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 */
	@DisplayName("Test: Get Price Test 5")
	@Test
	void testGeTPriceTest5_returnPrice(){

		// Params
		Long productId = EcommerceConstants.PRODUCT_ID;
		Long brandId = EcommerceConstants.BRAND_ID;

		PriceRequestDTO priceRequestDTO = new PriceRequestDTO("2020-06-16 21:00:00", productId.toString(), brandId.toString());

		List<Price> listMockBD = Arrays.asList(EcommerceData.getPrice01(), EcommerceData.getPrice02(), EcommerceData.getPrice03(), EcommerceData.getPrice04());

		// Given
		when(repository.findAllByBrandIdAndProductId(brandId,productId)).thenReturn(listMockBD);

		// When
		PriceDTO expectedPrice = service.findProductsPrice(priceRequestDTO);

		assertAll(() -> {
			assertNotNull(expectedPrice, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
		}, () -> {
			assertEquals(expectedPrice, EcommerceData.getPriceExpectedTest05(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_PRICE);
		},
		() -> {
			verify(repository, times(1)).findAllByBrandIdAndProductId(brandId, productId);
		});
	}

}
