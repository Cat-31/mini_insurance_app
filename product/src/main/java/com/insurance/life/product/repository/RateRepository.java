package com.insurance.life.product.repository;

import com.insurance.life.product.entity.Rate;
import org.springframework.data.repository.CrudRepository;

public interface RateRepository extends CrudRepository<Rate, Long> {
    Rate findByProductIdAndAgeAndGender(String productId, int age, String gender);
}
