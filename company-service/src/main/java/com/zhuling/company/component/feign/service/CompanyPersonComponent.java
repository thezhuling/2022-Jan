package com.zhuling.company.component.feign.service;

import com.zhuling.company.component.feign.fallback.CompanyPersonComponentFallBack;
import com.zhuling.repository.jan.entities.GcPersonEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "person-service",fallback = CompanyPersonComponentFallBack.class)
public interface CompanyPersonComponent {
    @GetMapping("person/list/{companyId}")
    List<GcPersonEntity> personListByCompanyId(@PathVariable("companyId") String companyId);

    @GetMapping("person/detail")
    String detail();
}
