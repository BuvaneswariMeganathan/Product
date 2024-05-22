package com.nielseniq.prodcut.dto.response;

import com.nielseniq.prodcut.dto.ProductData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataResponse extends BaseResponse{
    public List<ProductData> productDataList;
}
