package Config;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConfig {
    private static final String coneccion="mongodb://127.0.0.1:27017";
    private static final String bd="Cacho";

    public static MongoDatabase getMongo(){
        try{
            MongoClient mongoClient= MongoClients.create(coneccion);
            return mongoClient.getDatabase(bd);
        }catch (MongoException e){
            System.out.println("Error a conectarse a mongo: "+e.getLocalizedMessage());
            return null;
        }

    }
}
