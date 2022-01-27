package com.zhuling.order.dto;

import com.zhuling.model.dto.response.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto implements Serializable {
    private String orderName;
    private String orderNo;
    private List<ProductDto> products;
}
