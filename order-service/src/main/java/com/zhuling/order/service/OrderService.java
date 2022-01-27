package com.zhuling.order.service;

import com.zhuling.model.dto.response.ProductDto;
import com.zhuling.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto details(String id);

    List<ProductDto> list();

    ProductDto findProductDto(ProductDto productDto);
}
