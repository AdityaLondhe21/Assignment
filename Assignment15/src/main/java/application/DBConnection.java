package application;

import javax.swing.text.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.sql.SQLException;

public class DBConnection{
	static final String url = "mongodb://localhost:27017";
	static final String databaseName = "demodb";
	static final String collectionName = "Employee";
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<org.bson.Document> collection ;
	static {
		try {
            mongoClient = MongoClients.create(url);
            database = mongoClient.getDatabase(databaseName);
            collection = database.getCollection(collectionName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static MongoClient getConnection() {
		return mongoClient;
	}
	
	public static MongoDatabase getDatabase() {
		return database;
	}
	
	public static MongoCollection<org.bson.Document> getCollection() {
        return collection;
	}

}
