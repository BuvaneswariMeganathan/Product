package com.nielseniq.prodcut.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nielseniq.prodcut.dto.ProductData;
import com.nielseniq.prodcut.dto.response.BaseResponse;
import com.nielseniq.prodcut.dto.response.ProductDataResponse;

public interface ProductService {

    public BaseResponse saveProduct(ProductData saveRequest) throws JsonProcessingException;

    public ProductDataResponse retrieveProduct(String shopperId, String age, String brand, int limit) throws JsonProcessingException;
}
