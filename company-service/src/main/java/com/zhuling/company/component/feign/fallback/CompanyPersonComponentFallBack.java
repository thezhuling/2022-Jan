package com.zhuling.company.component.feign.fallback;

import com.zhuling.company.component.feign.service.CompanyPersonComponent;
import com.zhuling.repository.jan.entities.GcPersonEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyPersonComponentFallBack implements CompanyPersonComponent {
    @Override
    public List<GcPersonEntity> personListByCompanyId(String companyId) {
        return List.of(GcPersonEntity.builder().name("zs").build(), GcPersonEntity.builder().name("lisi").build());
    }

    @Override
    public String detail() {
        return "服务器繁忙,请稍后再试";
    }
}
