package com.ecommerce.msvcecommerce.domain.port.repositories;

import com.ecommerce.msvcecommerce.infraestructure.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByBrandIdAndProductId(Long brandId, Long productId);

    @Query("SELECT p FROM com.ecommerce.msvcecommerce.infraestructure.entities.Price p WHERE p.brandId = :brand and p.productId = :product and p.startDate >= :applicationDate and p.endDate <= :applicationDate")
    List<Price> findAllByParams(@Param("brand") Long brandId, @Param("product") Long productId, @Param("applicationDate")LocalDateTime applicationDate);
}
