package com.nielseniq.prodcut.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.nielseniq.prodcut.dto.ProductData;
import com.nielseniq.prodcut.dto.response.BaseResponse;
import com.nielseniq.prodcut.dto.response.ProductDataResponse;
import com.nielseniq.prodcut.service.ProductService;
import com.nielseniq.prodcut.utils.constants.ApiConstants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ApiConstants.API_V1 + ApiConstants.PRODUCT)
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping(ApiConstants.SAVE)
    public BaseResponse saveProduct(@RequestBody @Valid ProductData saveRequest) throws JsonProcessingException {
        return productService.saveProduct(saveRequest);
    }

    @GetMapping(ApiConstants.RETRIEVE)
    public ProductDataResponse getProducts(
            @RequestParam(name = "shopperId") @NotBlank(message = "shopperId is required") String shopperId,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "brand", required = false) String brand,
            @RequestParam(name = "limit", required = false, defaultValue = "10") @Min(value = 1, message = "limit should not below 1") @Max(value = 100, message = "limit should not exceed 100") int limit) throws JsonProcessingException {
        return productService.retrieveProduct(shopperId, category, brand, limit);
    }
}
