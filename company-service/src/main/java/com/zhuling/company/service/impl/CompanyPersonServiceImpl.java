package com.zhuling.company.service.impl;

import com.zhuling.company.component.feign.service.CompanyPersonComponent;
import com.zhuling.company.service.CompanyPersonService;
import com.zhuling.repository.entities.GcPersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CompanyPersonServiceImpl implements CompanyPersonService {
    @Resource
    private CompanyPersonComponent companyPersonComponent;

    @Override
    public List<GcPersonEntity> personListByCompanyId(String companyId) {
        return companyPersonComponent.personListByCompanyId(companyId);
    }

    @Override
    public String detail() {
        return companyPersonComponent.detail();
    }
}
