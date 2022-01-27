package com.zhuling.company.repository;

import com.redis.om.spring.annotations.Query;
import com.redis.om.spring.repository.RedisDocumentRepository;
import com.zhuling.company.document.Company;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CompanyRepository extends RedisDocumentRepository<Company, String> {
    // find one by property
    Optional<Company> findOneByName(String name);

    // geospatial query
    Iterable<Company> findByLocationNear(Point point, Distance distance);

    // find by tag field, using JRediSearch "native" annotation
    @Query("@tags:{$tags}")
    List<Company> findByTags(@Param("tags") Set<String> tags);

    // find by numeric property
    List<Company> findByNumberOfEmployees(int noe);

    // find by numeric property range
    List<Company> findByNumberOfEmployeesBetween(int noeGT, int noeLT);

    // starting with/ending with
    List<Company> findByNameStartingWith(String prefix);
}
