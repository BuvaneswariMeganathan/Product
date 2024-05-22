package com.nielseniq.prodcut.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nielseniq.prodcut.dto.ProductData;
import com.nielseniq.prodcut.dto.ProductData.ShelfItem;
import com.nielseniq.prodcut.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {
    public static List<ProductData> mapToProductDataDto(List<ProductEntity> entities) throws JsonProcessingException {
        List<ProductData> productDataList = new ArrayList<>();
        for (ProductEntity entity : entities) {
            productDataList.add(mapToProductDataDto(entity));
        }
        return productDataList;
    }

    public static ProductData mapToProductDataDto(ProductEntity entity) throws JsonProcessingException {
        return ProductData.builder().productList(
                new ProductData.ProductList(
                        entity.getShopperId(),
                        mapShelfItems(entity.getShelf()))
        ).metaData(new ProductData.MetaData(
                entity.getProductId(),
                entity.getCategory(),
                entity.getBrand()
        )).build();
    }

    private static List<ShelfItem> mapShelfItems(String shelfJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(shelfJson, new TypeReference<List<ProductData.ShelfItem>>() {
        });

    }
}
