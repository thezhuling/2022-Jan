package com.zhuling.company.service;

import com.zhuling.company.document.Company;
import com.zhuling.company.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyRepository repository;

    @Override
    public List<Company> findByNumberOfEmployees(Integer count) {
        return repository.findByNumberOfEmployees(count);
    }

    @Override
    public List<Company> findByNumberOfEmployeesBetween(Integer low, Integer high) {
        return repository.findByNumberOfEmployeesBetween(low, high);
    }


    @Override
    public Page<Company> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Iterable<Company> findByLocationNear(Point point, Distance distance) {
        log.info("经:{},纬:{},距离:{}", point.getX(), point.getY(), distance.getValue());
        return repository.findByLocationNear(point, distance);
    }


    @Override
    public List<Company> findByNameStartingWith(String prefix) {
        return repository.findByNameStartingWith(prefix);
    }


    @Override
    public Optional<Company> findOneByName(String name) {
        return repository.findOneByName(name);
    }


    @Override
    public List<Company> findByTags(Set<String> tags) {
        return repository.findByTags(tags);
    }


    @Override
    public Optional<Company> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Page<String> findIds(Pageable pageable) {
        return repository.getIds(pageable);
    }

    @Override
    public void init() {
        List<Company> list = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            Company company = Company.of("zhuling" + i, "https://www.zhuling" + i + ".cn", new Point(1 + i, 1 + i), i, i);
            company.setTags(Set.of("innovative", "reliable", "confident" + i));
            list.add(company);
        });
        repository.saveAll(list);
    }
}
