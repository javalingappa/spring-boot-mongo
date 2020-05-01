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
public class ConsolidatedInsured {
/*  private String id;*/
    private Long insuredNumber;
    private String place;
    private String type;
}
