package com.zhuling.company.service;

import com.zhuling.company.document.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyService {
    /**
     * 根据在职人数查询公司
     */
    List<Company> findByNumberOfEmployees(Integer count);

    /**
     * 根据在职人数区间范围查询公司
     */
    List<Company> findByNumberOfEmployeesBetween(Integer low, Integer high);

    /**
     * 查询所有公司信息
     */
    Page<Company> findAll(Pageable pageable);

    /**
     * 根据公司位置信息范围查询[经、纬度、距离]
     */
    Iterable<Company> findByLocationNear(Point point, Distance distance);


    /**
     * 根据公司名称前缀匹配查询
     */
    List<Company> findByNameStartingWith(String prefix);

    /**
     * 根据公司名称查询
     */
    Optional<Company> findOneByName(String name);

    /**
     * 根据公司特征描述查询
     */
    List<Company> findByTags(Set<String> tags);


    /**
     * 根据公司id查询
     */
    Optional<Company> findById(String id);


    Page<String> findIds(Pageable pageable);

    void init();
}
