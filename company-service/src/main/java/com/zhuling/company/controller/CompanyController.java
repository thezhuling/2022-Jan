package com.zhuling.company.controller;

import com.zhuling.company.document.Company;
import com.zhuling.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/company")
@Slf4j
public class CompanyController {

    @Resource
    private CompanyService companyService;

    /**
     * 根据在职人数查询公司
     */
    @GetMapping("employees/count/{count}")
    List<Company> byNumberOfEmployees(@PathVariable("count") Integer count) {
        return companyService.findByNumberOfEmployees(count);
    }

    /**
     * 根据在职人数区间范围查询公司
     */
    @GetMapping("employees/range/{low}/{high}")
    List<Company> byNumberOfEmployeesRange(@PathVariable("low") Integer low, @PathVariable("high") Integer high) {
        return companyService.findByNumberOfEmployeesBetween(low, high);
    }

    /**
     * 查询所有公司信息
     */
    @GetMapping("all")
    Page<Company> all(Pageable pageable) {
        return companyService.findAll(pageable);
    }

    /**
     * 根据公司位置信息范围查询[经、纬度、距离]
     */
    @GetMapping("near")
    Iterable<Company> byLocationNear(@RequestParam("lat") double lat,
                                     @RequestParam("lon") double lon,
                                     @RequestParam("d") double distance) {
        return companyService.findByLocationNear(new Point(lat, lon), new Distance(distance, Metrics.MILES));
    }


    /**
     * 根据公司名称前缀匹配查询
     */
    @GetMapping("name/starts/{prefix}")
    List<Company> byNameStartingWith(@PathVariable("prefix") String prefix) {
        return companyService.findByNameStartingWith(prefix);
    }


    /**
     * 根据公司名称查询
     */
    @GetMapping("name/{name}")
    Optional<Company> byName(@PathVariable("name") String name) {
        return companyService.findOneByName(name);
    }


    /**
     * 根据公司特征描述查询
     */
    @GetMapping("tags")
    List<Company> byTags(@RequestParam("tags") Set<String> tags) {
        return companyService.findByTags(tags);
    }


    /**
     * 根据公司id查询
     */
    @GetMapping("{id}")
    Optional<Company> byId(@PathVariable("id") String id) {
        return companyService.findById(id);
    }


    /**
     * 初始化数据
     */
    @GetMapping("save")
    String save() {
        companyService.init();
        return "success";
    }
}
