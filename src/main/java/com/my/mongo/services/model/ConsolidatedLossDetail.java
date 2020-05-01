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
public class ConsolidatedLossDetail {
 /*   private String id;*/
    private Integer lossDetailNumber;
    private Boolean isLost;
    private String lossLocation;
}
