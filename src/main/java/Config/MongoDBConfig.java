package Config;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConfig {
    private static final String coneccion="mongodb://127.0.0.1:27017";
    private static final String bd="Cacho";
    private static MongoDatabase database=null;
    private static MongoClient cliente=null;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            closeClient();
        }));
    }
    private MongoDBConfig(){}
    public static MongoDatabase getMongo(){
        if(database==null){
            try{
                cliente= MongoClients.create(coneccion);
                database= cliente.getDatabase(bd);
            }catch (MongoException e){
                System.out.println("Error a conectarse a mongo: "+e.getLocalizedMessage());
                return null;
            }
        }
        return database;
    }
    private static void closeClient() {
        if (cliente != null) {
            cliente.close();
        }
    }
}
