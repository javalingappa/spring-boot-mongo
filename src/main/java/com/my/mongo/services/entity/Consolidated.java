package com.my.mongo.services.entity;

import com.my.mongo.services.model.ConsolidatedAgentDetail;
import com.my.mongo.services.model.ConsolidatedContact;
import com.my.mongo.services.model.ConsolidatedInsured;
import com.my.mongo.services.model.ConsolidatedLossDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
/**
 * @author Javalingappa
 */

@Document(collection = "consolidated")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consolidated {
    @Id
    private String id;
    private String name;
    private String address;
    private String contactName;
    private String phone;
    private String email;
    List<ConsolidatedAgentDetail> agentDetails;
    List<ConsolidatedContact> contacts;
    List<ConsolidatedInsured> insureds;
    List<ConsolidatedLossDetail> lossDetails;
/*
    ConsolidatedAgentDetail agentDetail;
    ConsolidatedContact contact;
    ConsolidatedInsured insured;
    ConsolidatedLossDetail lossDetail;*/
}
