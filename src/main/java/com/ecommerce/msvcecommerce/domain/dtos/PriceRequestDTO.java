package com.ecommerce.msvcecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "PriceRequest", description = "Schema to hold the search of prices")
public class PriceRequestDTO {

    @NotEmpty(message = "Petition Date can not be null or empty")
    @Schema(description = "Petition Date to search", example = "2020-06-14 10:00:00")
    private String petitionDate;

    @NotEmpty(message = "Product can not be null or empty")
    @Pattern(regexp = "(^[0-9]*$)", message = "Product Id must be only number")
    @Schema(description = "Product ID to search", example = "1")
    private String productId;

    @NotEmpty(message = "Brand can not be null or empty")
    @Pattern(regexp = "(^[0-9]*$)", message = "Brand Id must be only number")
    @Schema(description = "Brand ID to search", example = "1")
    private String brandId;
}
