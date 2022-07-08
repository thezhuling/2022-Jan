package com.zhuling.person.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhuling.person.service.PersonService;
import com.zhuling.repository.jan.entities.GcPersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {
    private final static AtomicInteger count = new AtomicInteger(0);

    @Resource
    PersonService personService;

    @GetMapping("list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(personService.list());
    }

    @GetMapping("detail")
    public String detail() {
        int i = 1 / 0;
        return "ok";
    }

    @GetMapping("list/{companyId}")
    public List<GcPersonEntity> personListByCompanyId(@PathVariable("companyId") String companyId) {
        log.info("request-time:{}", count.getAndIncrement());
        return List.of(GcPersonEntity.builder().name("zs").build(), GcPersonEntity.builder().name("lisi").build());
    }

    @GetMapping("pressure/{id}")
    public List<GcPersonEntity> pressure(@PathVariable("id") String id) {
        log.info("request-time:{}", count.getAndIncrement());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(GcPersonEntity.builder().id(Long.valueOf(id)).name("zs").build(), GcPersonEntity.builder().name("lisi").build());
    }

    @HystrixCommand(fallbackMethod = "errorHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("error/{id}")
    public ResponseEntity<GcPersonEntity> error(@PathVariable("id") String id) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseEntity<GcPersonEntity> ok = ResponseEntity.ok(GcPersonEntity.builder()
                .name("zs")
                .id(222L)
                .address("beijing")
                .build());
        log.info("###:{}", ok);
        return ok;
    }

    public ResponseEntity<GcPersonEntity> errorHandler(@PathVariable("id") String id, Throwable throwable) {
        throwable.printStackTrace();
        return ResponseEntity.ok(GcPersonEntity.builder().name("服务器繁忙，请稍后再试").build());
    }

    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "serviceFuseFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
            @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "10"),
            @HystrixProperty(name = "fallback.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    @GetMapping("service-fuse/{id}")
    public String serviceFuse(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("系统异常,id不合法");
        }
        return "ok";
    }

    public String serviceFuseFallBack(@PathVariable("id") Integer id, Throwable throwable) {
        log.info("id小于0,系统服务异常：{}", throwable.getMessage());
        return "ok";
    }

    @GetMapping("atomic")
    public ResponseEntity<?> atomicGetAndSet() {
        log.info("request-time:{}", count.getAndIncrement());
        return ResponseEntity.ok("success");
    }
}
