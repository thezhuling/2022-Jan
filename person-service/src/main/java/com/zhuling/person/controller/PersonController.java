package com.zhuling.person.controller;

import com.zhuling.repository.entities.GcPersonEntity;
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
        log.info("###call person-service###:{}", companyId);
        return List.of(GcPersonEntity.builder().name("zs").build(), GcPersonEntity.builder().name("lisi").build());
    }
}
