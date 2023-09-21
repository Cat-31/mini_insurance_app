package com.insurance.life.underwriting.repository;

import com.insurance.life.underwriting.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
