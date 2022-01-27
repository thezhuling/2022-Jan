package com.zhuling.order.service;

import com.zhuling.model.dto.response.ProductDto;
import com.zhuling.order.dto.OrderDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ProductService productService;

    @Override
    public OrderDto details(String id) {
        OrderDto build = OrderDto.builder().build();
        build.setOrderNo("BT00001");
        build.setOrderName("京东生鲜到家");
        List<ProductDto> products = productService.products();
//        List<ProductDto> list = restTemplate.getForObject("http://eureka-product-service/product/list", List.class);
        build.setProducts(products);
        return build;
    }

    @Override
    public List<ProductDto> list() {
        return productService.products();
    }

    @Override
    public ProductDto findProductDto(ProductDto productDto) {
        return productService.findProductDto(productDto);
    }
}
