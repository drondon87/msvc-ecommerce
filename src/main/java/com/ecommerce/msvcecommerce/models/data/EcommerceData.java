package com.ecommerce.msvcecommerce.models.data;

import com.ecommerce.msvcecommerce.models.dtos.PriceDTO;
import com.ecommerce.msvcecommerce.models.entities.Price;
import com.ecommerce.msvcecommerce.utils.EcommerceConstants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EcommerceData {

    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static DateTimeFormatter getFormatter(){
        return  formatter;
    }

    public static Price getPrice01() {
        Price price = new Price();
        price.setBrandId(EcommerceConstants.BRAND_ID);
        price.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
        price.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
        price.setPriceList(1l);
        price.setProductId(EcommerceConstants.PRODUCT_ID);
        price.setPriority(0l);
        price.setPrice(35.50);
        price.setCurr(EcommerceConstants.CURR);
        return price;
    }

    public static Price getPrice02() {
        Price price2 = new Price();
        price2.setBrandId(EcommerceConstants.BRAND_ID);
        price2.setStartDate(LocalDateTime.parse("2020-06-14 15:00:00", formatter));
        price2.setEndDate(LocalDateTime.parse("2020-06-14 18:30:00", formatter));
        price2.setPriceList(2l);
        price2.setProductId(EcommerceConstants.PRODUCT_ID);
        price2.setPriority(EcommerceConstants.PRIORITY);
        price2.setPrice(25.45);
        price2.setCurr(EcommerceConstants.CURR);
        return price2;
    }

    public static Price getPrice03() {
        Price price3 = new Price();
        price3.setBrandId(EcommerceConstants.BRAND_ID);
        price3.setStartDate(LocalDateTime.parse("2020-06-15 00:00:00", formatter));
        price3.setEndDate(LocalDateTime.parse("2020-06-15 11:00:00", formatter));
        price3.setPriceList(3l);
        price3.setProductId(EcommerceConstants.PRODUCT_ID);
        price3.setPriority(EcommerceConstants.PRIORITY);
        price3.setPrice(30.50);
        price3.setCurr(EcommerceConstants.CURR);
        return price3;
    }

    public static Price getPrice04() {
        Price price4 = new Price();
        price4.setBrandId(EcommerceConstants.BRAND_ID);
        price4.setStartDate(LocalDateTime.parse("2020-06-15 16:00:00", formatter));
        price4.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
        price4.setPriceList(4l);
        price4.setProductId(EcommerceConstants.PRODUCT_ID);
        price4.setPriority(EcommerceConstants.PRIORITY);
        price4.setPrice(38.95);
        price4.setCurr(EcommerceConstants.CURR);
        return price4;
    }

    public static List<Price> getListPrices() {
        List<Price> prices = new ArrayList<>();
        prices.add(getPrice01());
        prices.add(getPrice02());
        prices.add(getPrice03());
        prices.add(getPrice04());
        return prices;
    }

    public static PriceDTO getPriceDto03() {
        PriceDTO priceDto3 = new PriceDTO();
        priceDto3.setProductId(EcommerceConstants.PRODUCT_ID);
        priceDto3.setBrandId(EcommerceConstants.BRAND_ID);
        priceDto3.setPrice("30.5 EUR");
        priceDto3.setFinalPrice("30.5 EUR");
        priceDto3.setApplicationDate("15/06/2020 00:00 - 15/06/2020 11:00");
        return priceDto3;
    }

    public static PriceDTO getPriceExpectedTest01() {
        PriceDTO priceDto3 = new PriceDTO();
        priceDto3.setProductId(EcommerceConstants.PRODUCT_ID);
        priceDto3.setBrandId(EcommerceConstants.BRAND_ID);
        priceDto3.setPrice("35.5 EUR");
        priceDto3.setFinalPrice("35.5 EUR");
        priceDto3.setApplicationDate("14/06/2020 00:00 - 31/12/2020 23:59");
        return priceDto3;
    }

    public static PriceDTO getPriceExpectedTest02() {
        PriceDTO priceDto3 = new PriceDTO();
        priceDto3.setProductId(EcommerceConstants.PRODUCT_ID);
        priceDto3.setBrandId(EcommerceConstants.BRAND_ID);
        priceDto3.setPrice("25.45 EUR");
        priceDto3.setFinalPrice("25.45 EUR");
        priceDto3.setApplicationDate("14/06/2020 15:00 - 14/06/2020 18:30");
        return priceDto3;
    }

    public static PriceDTO getPriceExpectedTest04() {
        PriceDTO priceDto3 = new PriceDTO();
        priceDto3.setProductId(EcommerceConstants.PRODUCT_ID);
        priceDto3.setBrandId(EcommerceConstants.BRAND_ID);
        priceDto3.setPrice("30.5 EUR");
        priceDto3.setFinalPrice("30.5 EUR");
        priceDto3.setApplicationDate("15/06/2020 00:00 - 15/06/2020 11:00");
        return priceDto3;
    }

    public static PriceDTO getPriceExpectedTest05() {
        PriceDTO priceDto3 = new PriceDTO();
        priceDto3.setProductId(EcommerceConstants.PRODUCT_ID);
        priceDto3.setBrandId(EcommerceConstants.BRAND_ID);
        priceDto3.setPrice("38.95 EUR");
        priceDto3.setFinalPrice("38.95 EUR");
        priceDto3.setApplicationDate("15/06/2020 16:00 - 31/12/2020 23:59");
        return priceDto3;
    }


}
