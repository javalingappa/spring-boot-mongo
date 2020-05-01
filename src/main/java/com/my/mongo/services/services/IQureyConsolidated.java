package com.my.mongo.services.services;

import com.my.mongo.services.entity.Consolidated;
import org.bson.Document;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface IQureyConsolidated {

    List<Document> generateAndFetchList();
}
