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
public class ConsolidatedContact {
    /*  private String id;*/
    private String fax;
    private String mobile;
    private String postalAddress;
}
