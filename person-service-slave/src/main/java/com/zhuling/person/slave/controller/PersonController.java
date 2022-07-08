package com.zhuling.person.slave.controller;

import com.zhuling.repository.jan.entities.GcPersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {
    @GetMapping("detail")
    public String detail() {
        return "ok";
    }

    @GetMapping("list/{companyId}")
    public List<GcPersonEntity> personListByCompanyId(@PathVariable("companyId") String companyId) {
        log.info("###call person-service-slave###:{}", companyId);
        return List.of(GcPersonEntity.builder().name("zl").build(), GcPersonEntity.builder().name("wq").build());
    }
}
