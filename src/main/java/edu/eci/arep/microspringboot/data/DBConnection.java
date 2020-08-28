package edu.eci.arep.microspringboot.data;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class DBConnection {
    MongoClientURI uri;
    MongoClient mongoClient;

    public DBConnection() {
        uri = new MongoClientURI(
                "mongodb+srv://AREPUser:AREPUser123@arepdbserver.po3hu.gcp.mongodb.net/sample_mflix.movies?retryWrites=true&w=majority");
        mongoClient = new MongoClient(uri);
    }

    public String getMovies(String filter){
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection =database.getCollection("movies");
        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<Document>();
        StringBuilder results = new StringBuilder();
        fit.into(docs);
        for (Document doc : docs) {
            if (doc.get("title")!= null){
                ArrayList lol = (ArrayList)doc.get("genres");
                System.out.println(lol);
                if (lol!= null && lol.contains(filter)) {
                    results.append(" \n").append(" ").append(doc.get("title"));

                }
            }
            else{
                continue;
            }

        }
        return results.toString();

    }
}
