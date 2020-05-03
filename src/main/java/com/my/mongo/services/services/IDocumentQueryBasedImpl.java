package com.my.mongo.services.services;

import org.bson.Document;

import java.util.List;
/**
 * @author Javalingappa
 */

public interface IDocumentQueryBasedImpl {

    List<Document> generateAndFetchList(Boolean isFirst);
}
