package com.my.mongo.services.repository;

import com.my.mongo.services.entity.AgentDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface AgentaDetailRepository extends MongoRepository<AgentDetail, String> {
    List<AgentDetail> findAllByAgentId(String agentId);
}
