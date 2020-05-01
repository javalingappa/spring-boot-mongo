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

@Document(collection = "lossdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LossDetail {

    @Id
    private String id;

    private String agentId;

    private Integer lossDetailNumber;
    private Boolean isLost;
    private String lossLocation;
}
