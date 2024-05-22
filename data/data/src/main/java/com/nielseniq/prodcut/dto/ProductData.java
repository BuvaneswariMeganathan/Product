package com.nielseniq.prodcut.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductData {

    @NotNull(message = "Invalid productList")
    @Valid
    private ProductList productList;

    @NotNull(message = "Invalid metaData")
    @Valid
    private MetaData metaData;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductList {
        @NotBlank(message = "Invalid shopperId")
        private String shopperId;
        @NotNull(message = "Invalid shelf")
        @Valid
        private List<ShelfItem> shelf;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShelfItem {
        @NotBlank(message = "Invalid productId in ShelfItem")
        private String productId;
        @NotBlank(message = "Invalid relavancyScore")
        private String relavancyScore;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MetaData {
        @NotBlank(message = "Invalid productId in MetaData")
        private String productId;
        @NotBlank(message = "Invalid category")
        private String category;
        @NotBlank(message = "Invalid brand")
        private String brand;
    }
}
