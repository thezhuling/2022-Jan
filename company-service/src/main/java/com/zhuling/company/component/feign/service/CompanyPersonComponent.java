package com.zhuling.company.component.feign.service;

import com.zhuling.repository.entities.GcPersonEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient("person-service")
public interface CompanyPersonComponent {
    @GetMapping("person/list/{companyId}")
    List<GcPersonEntity> personListByCompanyId(@PathVariable("companyId") String companyId);

    @GetMapping("person/detail")
    String detail();
}
