package com.nielseniq.prodcut.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nielseniq.prodcut.dto.ProductData;
import com.nielseniq.prodcut.dto.response.BaseResponse;
import com.nielseniq.prodcut.dto.response.ProductDataResponse;
import com.nielseniq.prodcut.entity.ProductEntity;
import com.nielseniq.prodcut.helper.ProductHelper;
import com.nielseniq.prodcut.repository.ProductRepository;
import com.nielseniq.prodcut.service.ProductService;
import com.nielseniq.prodcut.utils.InfoId;
import com.nielseniq.prodcut.utils.InfoMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public BaseResponse saveProduct(ProductData saveRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        productRepository.save(ProductEntity.builder()
                .shopperId(saveRequest.getProductList().getShopperId())
                .shelf(objectMapper.writeValueAsString(saveRequest.getProductList().getShelf()))
                .productId(saveRequest.getMetaData().getProductId())
                .category(saveRequest.getMetaData().getCategory())
                .brand(saveRequest.getMetaData().getBrand())
                .build()
        );
        return BaseResponse.builder().infoId(InfoId.SUCCESS).infoMsg(InfoMsg.SAVE_SUCCESS).build();
    }

    public ProductDataResponse retrieveProduct(String shopperId, String category, String brand, int limit) throws JsonProcessingException {
        ProductDataResponse productDataResponse = new ProductDataResponse();
        productDataResponse.setInfoId(InfoId.SUCCESS);
        productDataResponse.setInfoMsg(InfoMsg.RETRIEVE_SUCCESS);
        productDataResponse.setProductDataList(ProductHelper.mapToProductDataDto(productRepository.findByShopperIdAndCategoryAndBrandWithLimit(shopperId, category, brand, limit)));
        return productDataResponse;
    }
}
