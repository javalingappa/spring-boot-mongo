package com.my.mongo.services.repository;

import com.my.mongo.services.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findAllByAgentId(String agentId);
}
