package com.insurance.life.sales.repository;

import com.insurance.life.sales.repository.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, String> {
}
