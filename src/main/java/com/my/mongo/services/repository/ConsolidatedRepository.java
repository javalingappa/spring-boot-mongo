package com.my.mongo.services.repository;

import com.my.mongo.services.entity.Consolidated;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author Javalingappa
 */

public interface ConsolidatedRepository extends MongoRepository<Consolidated, String> {

}
