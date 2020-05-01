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

@Document(collection = "agent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agent {

    @Id
    private String id;

    private String name;
    private String address;
    private String contactName;
    private String phone;
    private String email;

}
