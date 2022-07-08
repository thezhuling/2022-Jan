package com.zhuling.person.service.impl;

import com.zhuling.person.service.PersonService;
import com.zhuling.repository.jan.entities.GcPersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Override
    public List<GcPersonEntity> list() {
        return null;
    }
}
