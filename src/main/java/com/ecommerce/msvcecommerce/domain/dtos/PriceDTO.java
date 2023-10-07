package com.ecommerce.msvcecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Prices", description = "Schema to hold prices")
public class PriceDTO {

    @Schema(description = "Product Id")
    private Long productId;

    @Schema(description = "Brand Id")
    private Long brandId;

    @Schema(description = "Product Price")
    private String price;

    @Schema(description = "Products Application Dates")
    private String applicationDate;

    @Schema(description = "Product Final Price")
    private String finalPrice;
}
