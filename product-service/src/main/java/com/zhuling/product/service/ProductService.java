package com.zhuling.product.service;

import com.zhuling.model.dto.response.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> list();

    ProductDto findProductDto(ProductDto productDto);

    ProductDto productDetails(String productId);
}
