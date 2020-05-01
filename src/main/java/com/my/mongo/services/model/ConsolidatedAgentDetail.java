package com.my.mongo.services.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Javalingappa
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsolidatedAgentDetail {
    /*private String id;*/
    private int adNumber;
    private String details;
    private String state;
}
