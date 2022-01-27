package com.zhuling.product.controller;

import com.zhuling.model.dto.response.ProductDto;
import com.zhuling.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("list")
    public List<ProductDto> products() {
        return productService.list();
    }

    @GetMapping("details/{productId}")
    public ProductDto productDetails(@PathVariable(name = "productId") String productId) {
        return productService.productDetails(productId);
    }

    @GetMapping("find-dto")
    public ProductDto findProductDto(@RequestBody ProductDto productDto) {
        return productService.findProductDto(productDto);
    }
}
