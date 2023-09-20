package com.insurance.life.sales.repository;

import com.insurance.life.sales.entity.ApplicationRecord;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRecordRepository extends CrudRepository<ApplicationRecord, String> {
}
