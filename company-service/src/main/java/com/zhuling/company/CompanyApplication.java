package com.zhuling.company;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import com.zhuling.company.document.Company;
import com.zhuling.company.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootApplication
@EnableFeignClients
@EnableRedisDocumentRepositories(basePackages = "com.zhuling.company.*")
public class CompanyApplication {
    @Resource
    private CompanyRepository companyRepo;

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Bean
    CommandLineRunner loadTestData() {
        return args -> {
            companyRepo.deleteAll();
            Company redis = Company.of("Redis", "https://redis.com", new Point(-122.066540, 37.377690), 526, 2011);
            redis.setTags(Set.of("fast", "scalable", "reliable"));

            Company microsoft = Company.of("Microsoft", "https://microsoft.com", new Point(-122.124500, 47.640160), 182268, 1975);
            microsoft.setTags(Set.of("innovative", "reliable"));

            companyRepo.save(redis);
            companyRepo.save(microsoft);

/*            personRepo.deleteAll();
            personRepo.save(Person.of("Brian", "Sam-Bodden", "bsb@redis.com"));
            personRepo.save(Person.of("Guy", "Royse", "guy.royse@redis.com"));
            personRepo.save(Person.of("Guy", "Korland", "guy.korland@redis.com"));*/
        };
    }
}
