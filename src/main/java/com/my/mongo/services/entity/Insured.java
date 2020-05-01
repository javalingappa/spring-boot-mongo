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

@Document(collection = "insured")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insured {

    @Id
    private String id;

    private String agentId;

    private Long insuredNumber;
    private String place;
    private String type;
}
