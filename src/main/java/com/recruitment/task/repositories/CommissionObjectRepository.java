package com.recruitment.task.repositories;

import com.recruitment.task.models.CommissionObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionObjectRepository extends MongoRepository<CommissionObject, String> {
}
