package com.my.mongo.services.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Javalingappa
 */
@Service
public class DocumentQueryBasedImpl implements IDocumentQueryBasedImpl {


    @Override
    public List<Document> generateAndFetchList(Boolean isFirst) {

        return generateData(isFirst);
    }

    public List<Document> generateData(Boolean isFirst) {
        List<Document> out = new ArrayList<>();
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"));
        MongoDatabase database = mongoClient.getDatabase("Claim");
        MongoCollection<Document> collection = database.getCollection("agent");

        AggregateIterable<Document> resultWithAgent = collection.aggregate(Arrays.asList(
                Aggregates.lookup("agent", "_id", "_id", "agent"),
                Aggregates.lookup("agentdetail", "_id", "agentId", "agentdetail"),
                Aggregates.lookup("contact", "_id", "agentId", "contact")
        ));

        if (database.getCollection("new_agent") == null) {
            database.createCollection("new_agent");
        }
        if (database.getCollection("new_contact") == null) {
            database.createCollection("new_contact");
        }
        if (database.getCollection("new_agentdetail") == null) {
            database.createCollection("new_agentdetail");
        }

        MongoCollection<Document> collectionName = null;
        Document filter = null;
        String agentId = getRandomId("A");
        Document exisitingDoc = null;
        int count = 0;
        for (Document doc : resultWithAgent) {

            collectionName = database.getCollection("new_agent");
            List<Document> agentList = doc.get("agent", List.class);
            if (agentList != null && agentList.size() > 0) {
                for (Document aDoc : agentList) {
                    filter = new Document();
                    filter.put("_id", aDoc.get("_id"));
                    agentId = isFirst ? "" + aDoc.get("_id") : getRandomId("A");
                    aDoc.put("agentId", agentId);
                    exisitingDoc = collectionName.find(filter).first();
                    if (exisitingDoc != null) {
                        collectionName.deleteOne(filter);
                        collectionName.insertOne(aDoc);
                    } else {
                        collectionName.insertOne(aDoc);
                    }
                }
            }

            collectionName = database.getCollection("new_agentdetail");
            List<Document> agentDetails = doc.get("agentdetail", List.class);
            if (agentDetails != null && agentDetails.size() > 0) {
                for (Document adDoc : agentDetails) {
                    filter = new Document();
                    filter.put("_id", adDoc.get("_id"));
                    adDoc.put("agentId", agentId);
                    exisitingDoc = collectionName.find(filter).first();
                    if (exisitingDoc != null) {
                        collectionName.deleteOne(filter);
                        collectionName.insertOne(adDoc);
                    } else {
                        collectionName.insertOne(adDoc);
                    }
                }
            }

            collectionName = database.getCollection("new_contact");
            List<Document> contact = doc.get("contact", List.class);
            if (contact != null && contact.size() > 0) {
                for (Document cDoc : contact) {
                    filter = new Document();
                    filter.put("_id", cDoc.get("_id"));
                    cDoc.put("agentId", agentId);
                    exisitingDoc = collectionName.find(filter).first();
                    if (exisitingDoc != null) {
                        collectionName.deleteOne(filter);
                        collectionName.insertOne(cDoc);
                    } else {
                        collectionName.insertOne(cDoc);
                    }
                }
            }

        }
        return out;
    }

    //approach two
    private String getRandomId(String append) {
        return append + System.currentTimeMillis();
    }

}
