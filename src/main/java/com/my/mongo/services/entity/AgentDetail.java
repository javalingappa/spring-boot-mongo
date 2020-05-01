package com.my.mongo.services.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author Javalingappa
 */

@Document(collection = "agentdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgentDetail {

    @Id
    private String id;

    private String agentId;

    private int adNumber;
    private String details;
    private String state;
}
