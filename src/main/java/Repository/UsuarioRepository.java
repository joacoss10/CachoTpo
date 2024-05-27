package Repository;

import Config.MongoDBConfig;
import Model.Usuario;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.ArrayList;

public class UsuarioRepository {
    private static MongoDatabase db;
    private static MongoCollection <Document> collection;

    public UsuarioRepository(){
        try {
            db = MongoDBConfig.getMongo();
            collection = db.getCollection("Usuarios");
        }catch (NullPointerException e){
            System.out.println("No se encontro la coleccion 'Usuarios': "+e.getMessage());
        }
    }
    public void registrarUsuario(Usuario usuario){
        try {
            Document doc=new Document("_id",usuario.getDni())
                    .append("nombre",usuario.getNombre())
                    .append("apellido", usuario.getApellido())
                    .append("direccion",usuario.getDireccion())
                    .append("contrasenia",usuario.getContrasenia());
            collection.insertOne(doc);
        }catch (MongoException e){
            System.out.println("Error al guardar al Usuario:"+e.getMessage());
        }
    }
    public void agregarPedido(int usuarioID, String pedidoId) {
        try {
            Document query = new Document("_id", usuarioID);
            Document usuario = collection.find(query).first();
                if (!usuario.containsKey("pedidos")) {
                    collection.updateOne(query, Updates.set("pedidos", new ArrayList<String>()));
                }
                collection.updateOne(query, Updates.push("pedidos", pedidoId));
        } catch (MongoException e) {
            System.out.println("Error al agregar el pedido: " + e.getMessage());
        }
    }
    public Usuario obtenerUsuario(int usuarioID){
        try{
            Document cli=new Document("_id",usuarioID);
            Document r=collection.find(cli).first();
            Usuario c=null;
            if(r!=null){
                c=new Usuario(r.getInteger("_id"),r.getString("nombre"),r.getString("apellido"),r.getString("direccion"),r.getString("contrasenia"));
                c.setCategoria(r.getString("categoria"));
                if (r.containsKey("pedidos")) {
                    ArrayList<String> pedidosDoc = (ArrayList<String>) r.get("pedidos");
                    c.setPedidos(pedidosDoc);
                }
            }
            return c;
        }catch (MongoException e){
            System.out.println("Error al recuperar al usuario: "+e.getMessage());
            return null;
        }
    }
    public void actualizarCategoria(int dni,String nuevaCategoria){
        try {
            Document query = new Document("_id", dni);
            Document usuario = collection.find(query).first();
            if (!usuario.containsKey("categoria")) {
                collection.updateOne(query, Updates.set("categoria", nuevaCategoria));
            }
            collection.updateOne(query, Updates.set("categoria", nuevaCategoria));
        } catch (MongoException e) {
            System.out.println("Error al actualizar la categoria: " + e.getMessage());
        }
    }
}

