package com.zhuling.order.component.feign.service;

import com.zhuling.model.dto.response.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(value = "product-service")
public interface ProductService {
    @GetMapping("/product/list")
    List<ProductDto> products();

    @GetMapping("/product/details/{productId}")
    ProductDto productDetails(@PathVariable(name = "productId") String productId);

    @GetMapping("/product/find-dto")
    ProductDto findProductDto(@RequestBody ProductDto productDto);
}
