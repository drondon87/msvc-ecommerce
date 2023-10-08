package com.ecommerce.msvcecommerce.infraestructure.controllers;

import com.ecommerce.msvcecommerce.domain.dtos.ErrorResponseDTO;
import com.ecommerce.msvcecommerce.domain.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.domain.dtos.PriceRequestDTO;
import com.ecommerce.msvcecommerce.application.services.IPriceServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "REST APIs for Prices Products", description = "REST APIs for Prices Products")
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class PriceController {

    @Autowired
    private IPriceServices priceServices;

    @Operation(summary = "Get Prices REST API", description = "REST API to get all Prices")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode="500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/prices")
    public ResponseEntity<List<PriceDTO>> getAllPrices(){
        List<PriceDTO> pricesDto = priceServices.getAllPrices();
        return ResponseEntity.status(HttpStatus.OK).body(pricesDto);
    }

    @Operation(summary = "Get Filter Prices REST API", description = "REST API to get filter prices by product ID, brand ID and pettition Date")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode="500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping("/filterPrices")
    public ResponseEntity<PriceDTO> getFilterPrices(@Valid @RequestBody PriceRequestDTO priceRequestDTO){
        PriceDTO pricesDTO = priceServices.findProductsPrice(priceRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pricesDTO);
    }

    @Operation(summary = "Get Filter Prices REST API", description = "REST API to get filter prices by product ID, brand ID and pettition Date")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode="500", description = "HTTP Status Internal Server Error")
    })
    @GetMapping("/price")
    public ResponseEntity<PriceDTO> getPriceByFilter(
            @RequestParam @Pattern(regexp="(^[0-9]*$)",message = "Product Id must be only number") String productId,
            @RequestParam @Pattern(regexp="(^[0-9]*$)",message = "Brand Id must be only number") String brandId,
            @RequestParam String petitionDate
        ){
        PriceRequestDTO priceRequestDTO = new PriceRequestDTO(petitionDate,productId, brandId);
        PriceDTO pricesDTO = priceServices.findProductsPrice(priceRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pricesDTO);
    }



}
