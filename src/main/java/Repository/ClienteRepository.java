package Repository;

import Config.MongoDBConfig;
import Model.Cliente;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.ArrayList;

public class ClienteRepository {
    private  MongoDatabase db;
    private MongoCollection <Document> collection;

    public ClienteRepository(){
        try {
            this.db = MongoDBConfig.getMongo();
            this.collection = db.getCollection("Clientes");
        }catch (NullPointerException e){
            System.out.println("No se encontro la coleccion 'cliente': "+e.getMessage());
        }
    }
    public void guardarCLiente(Cliente cliente){
        try {
            Document doc=new Document("_id",cliente.getDni())
                    .append("nombre",cliente.getNombre())
                    .append("apellido", cliente.getApellido())
                    .append("direccion",cliente.getDireccion());
            collection.insertOne(doc);
        }catch (MongoException e){
            System.out.println("Error al guardar el cliente:"+e.getMessage());
        }
    }
    public void agregarPedido(int clienteId, String pedidoId) {
        try {
            Document query = new Document("_id", clienteId);
            Document cliente = collection.find(query).first();
                if (!cliente.containsKey("pedidos")) {
                    collection.updateOne(query, Updates.set("pedidos", new ArrayList<String>()));
                }
                collection.updateOne(query, Updates.push("pedidos", pedidoId));
        } catch (MongoException e) {
            System.out.println("Error al agregar el pedido: " + e.getMessage());
        }
    }
    public Cliente obtenerCliente(int clienteId){
        try{
            Document cli=new Document("_id",clienteId);
            Document r=collection.find(cli).first();
            Cliente c=null;
            if(r!=null){
                c=new Cliente(r.getInteger("_id"),r.getString("nombre"),r.getString("apellido"),r.getString("direccion"));
                if (r.containsKey("pedidos")) {
                    ArrayList<String> pedidosDoc = (ArrayList<String>) r.get("pedidos");
                    c.setPedidos(pedidosDoc);
                }
            }
            return c;
        }catch (MongoException e){
            System.out.println("Error al recuperar al cliente: "+e.getMessage());
            return null;
        }
    }
}
