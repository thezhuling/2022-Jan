package com.zhuling.company.service;

import com.zhuling.repository.jan.entities.GcPersonEntity;

import java.util.List;

public interface CompanyPersonService {
    List<GcPersonEntity> personListByCompanyId(String companyId);

    String detail();
}
