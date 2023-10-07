package com.ecommerce.msvcecommerce.infraestructure.controllers;

import com.ecommerce.msvcecommerce.domain.dtos.PriceRequestDTO;
import com.ecommerce.msvcecommerce.infraestructure.utils.EcommerceConstants;
import com.ecommerce.msvcecommerce.utils.ErrorMessageTestCases;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTestCases {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    private String requestMapping = "/api/";

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    private String createUrl(String uri) {
        return "http://localhost:" + puerto + requestMapping + uri;
    }

    @DisplayName("Test: Get All Prices")
    @Test
    @Order(1)
    void testGetAllPrices_returnPrices() {
        ResponseEntity<Object> response = client.getForEntity(createUrl("prices"), Object.class);
        Object body = response.getBody();
        List<String> objectResponse = (ArrayList<String>) body;

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(objectResponse.size(), 4, () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_RESPONSE_SIZE);
        });
    }

    @DisplayName("Test: Get Price")
    @Test
    @Order(2)
    void testGetPrices_returnPrices() {

        // Params
        Long productId = EcommerceConstants.PRODUCT_ID;
        Long brandId = EcommerceConstants.BRAND_ID;

        // Given
        PriceRequestDTO priceRequestDTO = new PriceRequestDTO("2020-06-15 10:00:00", productId.toString(), brandId.toString());

        ResponseEntity<Object> response = client.postForEntity(createUrl("filterPrices"),priceRequestDTO, Object.class);
        Object body = response.getBody();

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(body, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        });
    }
}
