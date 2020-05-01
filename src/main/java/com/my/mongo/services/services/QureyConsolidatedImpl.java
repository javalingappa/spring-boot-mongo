package com.my.mongo.services.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.my.mongo.services.repository.ConsolidatedRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Javalingappa
 */
@Service
public class QureyConsolidatedImpl implements IQureyConsolidated {

    @Autowired
    ConsolidatedRepository consolidatedRepository;

    @Override
    public List<Document> generateAndFetchList() {

        return generateData();
    }

    public List<Document> generateData() {
        List<Document> out = new ArrayList<>();
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"));
        MongoDatabase database = mongoClient.getDatabase("Claim");
        MongoCollection<Document> collection = database.getCollection("agent");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                Aggregates.lookup("agentdetail", "_id", "agentId", "agentdetails"),
                Aggregates.unwind("$agentdetails"), Aggregates.lookup("contact", "_id", "agentId", "contacts"),
                Aggregates.unwind("$contacts"), Aggregates.lookup("insured", "_id", "agentId", "insured"),
                Aggregates.unwind("$insured"), Aggregates.lookup("lossdetail", "_id", "agentId", "lossdetails"),
                Aggregates.unwind("$lossdetails")));
        MongoCollection<Document> collectionConsolidated = database.getCollection("consolidated");
        int count = 0;
        if (collectionConsolidated != null && collectionConsolidated.getNamespace().getCollectionName().equalsIgnoreCase("Consolidated")) {
            for (Document doc : result) {
                Document filter = new Document();
                String _id = "c" + (++count) + doc.get("_id");
                filter.put("_id", _id);
                Document exisitingDoc = collectionConsolidated.find(filter).first();
                if (exisitingDoc != null) {
                    collectionConsolidated.deleteOne(filter);
                    doc.put("agentId", doc.get("_id"));
                    doc.put("_id", _id);
                    doc.remove("_class");
                    out.add(doc);
                    collectionConsolidated.insertOne(doc);
                } else {
                    doc.put("agentId", doc.get("_id"));
                    doc.put("_id", _id);
                    doc.remove("_class");
                    out.add(doc);
                    collectionConsolidated.insertOne(doc);
                }

            }
        } else {
            database.createCollection("consolidated");
            for (Document doc : result) {
                collection.deleteOne(doc);
                doc.put("agentId", doc.get("_id"));
                doc.put("_id", "c" + (++count) + doc.get("_id"));
                doc.remove("_class");
                out.add(doc);
                collectionConsolidated.insertOne(doc);
            }
        }
        return out;
    }
}
