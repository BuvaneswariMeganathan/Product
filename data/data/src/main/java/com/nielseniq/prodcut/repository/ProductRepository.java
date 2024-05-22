package com.nielseniq.prodcut.repository;


import com.nielseniq.prodcut.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    @Query(value = "SELECT * FROM product p WHERE p.shopper_id = :shopperId" +
            " AND (:category IS NULL OR p.category = :category)" +
            " AND (:brand IS NULL OR p.brand = :brand)" +
            " LIMIT :limit", nativeQuery = true)
    List<ProductEntity> findByShopperIdAndCategoryAndBrandWithLimit(
            @Param("shopperId") String shopperId,
            @Param("category") String category,
            @Param("brand") String brand,
            @Param("limit") int limit);
}

