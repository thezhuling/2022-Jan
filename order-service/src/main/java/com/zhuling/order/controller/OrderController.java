package com.zhuling.order.controller;

import com.zhuling.model.dto.response.ProductDto;
import com.zhuling.order.dto.OrderDto;
import com.zhuling.order.service.OrderService;
import com.zhuling.order.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    @GetMapping("products")
    public List<ProductDto> products() {
        return productService.products();
    }

    @GetMapping("product-details/{productId}")
    public ProductDto productDetails(@PathVariable(name = "productId") String productId) {
        return productService.productDetails(productId);
    }

    @GetMapping("details/{id}")
    public OrderDto details(@PathVariable(name = "id") String id) {
        return orderService.details(id);
    }

    @GetMapping("find-dto")
    public ProductDto findDto(ProductDto productDto) {
        return orderService.findProductDto(productDto);
    }
}
