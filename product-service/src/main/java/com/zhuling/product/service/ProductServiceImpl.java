package com.zhuling.product.service;

import com.zhuling.model.dto.response.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductDto> list() {
        return Arrays.asList(ProductDto.builder().name("apple").price(new BigDecimal("888")).count(100L).desc("apple").build(),
                ProductDto.builder().name("orange").price(new BigDecimal("999")).count(10L).desc("orange").build(),
                ProductDto.builder().name("pear").price(new BigDecimal("777")).count(100L).desc("pear").build(),
                ProductDto.builder().name("beer").price(new BigDecimal("666")).count(100L).desc("beer").build());
    }

    @Override
    public ProductDto findProductDto(ProductDto productDto) {
        return productDto;
    }


    @Override
    public ProductDto productDetails(String productId) {
        return ProductDto.builder().name("MacBookPro").count(888L).desc(productId).price(BigDecimal.valueOf(18999.00)).build();
    }
}
