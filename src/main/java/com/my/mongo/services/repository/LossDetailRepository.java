package com.my.mongo.services.repository;

import com.my.mongo.services.entity.LossDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface LossDetailRepository extends MongoRepository<LossDetail, String> {
    List<LossDetail> findAllByAgentId(String agentId);
}
