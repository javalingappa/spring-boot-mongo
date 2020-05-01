package com.my.mongo.services.services;

import com.my.mongo.services.entity.Consolidated;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface IConsolidatedService {

    List<Consolidated> generateConsolidatedClaims();

    Consolidated generateConsolidatedClaims(String agentId);
}
