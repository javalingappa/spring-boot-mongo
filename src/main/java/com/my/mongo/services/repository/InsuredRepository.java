package com.my.mongo.services.repository;

import com.my.mongo.services.entity.Insured;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface InsuredRepository extends MongoRepository<Insured, String> {
    List<Insured> findAllByAgentId(String agentId);
}
