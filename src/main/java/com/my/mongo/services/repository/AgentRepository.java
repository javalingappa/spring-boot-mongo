package com.my.mongo.services.repository;

import com.my.mongo.services.entity.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author Javalingappa
 */

public interface AgentRepository extends MongoRepository<Agent, String> {
}
