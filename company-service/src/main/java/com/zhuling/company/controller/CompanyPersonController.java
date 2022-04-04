package com.zhuling.company.controller;

import com.zhuling.company.component.feign.service.ProductService;
import com.zhuling.company.service.CompanyPersonService;
import com.zhuling.model.dto.response.ProductDto;
import com.zhuling.repository.entities.GcPersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/company-person")
@Slf4j
public class CompanyPersonController {
    @Resource
    private CompanyPersonService companyPersonService;

    @Resource
    private ProductService productService;

    @GetMapping("list/{companyId}")
    public List<GcPersonEntity> personList(@PathVariable String companyId) {
        return companyPersonService.personListByCompanyId(companyId);
    }

    @GetMapping("person/detail")
    public String detail() {
        return companyPersonService.detail();
    }

    @GetMapping("/product/list")
    public List<ProductDto> products() {
        return productService.products();
    }
}
