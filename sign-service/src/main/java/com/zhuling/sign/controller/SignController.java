package com.zhuling.sign.controller;

import com.zhuling.repository.jan.entities.GcPersonEntity;
import com.zhuling.sign.util.RocketMQTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sign")
@Slf4j
public class SignController {
    @Resource
    RocketMQTemplateUtil<Object> rocketMQTemplateUtil;

    @GetMapping
    public String sign() {
        String topic = "sign";
        GcPersonEntity gcPersonEntity = GcPersonEntity.builder().name("张三").address("北京市").build();
        rocketMQTemplateUtil.asyncSend(topic, gcPersonEntity);
        return "ok";
    }
}
