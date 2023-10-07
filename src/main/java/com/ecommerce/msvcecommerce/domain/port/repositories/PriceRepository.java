package com.ecommerce.msvcecommerce.domain.port.repositories;

import com.ecommerce.msvcecommerce.infraestructure.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByBrandIdAndProductId(Long brandId, Long productId);
}