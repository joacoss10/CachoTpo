package Repository;

import Config.CassandraDBConfig;
import Model.Catalogo;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.DriverException;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

public class CatalogoRepository {
    private static CqlSession sesion=null;
    private static final String tabla="Catalogo";

    public CatalogoRepository(){
        sesion= CassandraDBConfig.getCassandra();
    }
    public void nuevoProducto(Catalogo producto){
        String insertQuery = String.format("INSERT INTO %s (id, nombre, descripcion, precio, stock, descuento, video, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", tabla);
        try {
            sesion.execute(insertQuery,
                    producto.getId(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getStock(),
                    producto.getDescuento(),
                    producto.getVideo(),
                    producto.getFoto()
            );
         }catch (DriverException e){
            System.out.println("Error al guardar el producto: "+e.getMessage());
        }
    }
    public Catalogo obtenerProducto(int idProducto){
        String query=String.format("SELECT * FROM Catalogo WHERE id = ?");
        Catalogo c=null;
        try {
            ResultSet resultSet = sesion.execute(query, idProducto);
            for (Row r: resultSet){
                c=new Catalogo(r.getInt("id"),r.getString("nombre"),r.getString("descripcion"),r.getDouble("precio"),r.getInt("stock"),r.getString("video"),r.getString("foto"),r.getDouble("descuento"));
            }
        }catch (DriverException e){
            System.out.println("Error al obtener el producto: "+e.getMessage());
        }
        return c;
    }
    public void editarPrecio(int idProducto,double precio){
        String query=String.format("UPDATE Catalogo SET precio = ? WHERE id = ?");
        try {
            PreparedStatement statement=sesion.prepare(query);
            ResultSet r=sesion.execute(statement.bind(precio,idProducto));
        }catch (DriverException e){
            System.out.println("Error al actualizar el Precio:"+e.getMessage());
        }
    }
    public void editarStock(int idProducto,int stock){
        String query=String.format("UPDATE Catalogo SET stock = ? WHERE id = ?");
        try {
            PreparedStatement statement=sesion.prepare(query);
            ResultSet r=sesion.execute(statement.bind(stock,idProducto));
        }catch (DriverException e){
            System.out.println("Error al actualizar el stock:"+e.getMessage());
        }
    }
    public void editarVideo(int idProducto,String url){
        String query=String.format("UPDATE Catalogo SET video = ? WHERE id = ?");
        try {
            PreparedStatement statement=sesion.prepare(query);
            ResultSet r=sesion.execute(statement.bind(url,idProducto));
        }catch (DriverException e){
            System.out.println("Error al actualizar el video:"+e.getMessage());
        }
    }
    public void editarDescuento(int idProducto,double descuento){
        String query=String.format("UPDATE Catalogo SET descuento = ? WHERE id = ?");
        try {
            PreparedStatement statement=sesion.prepare(query);
            ResultSet r=sesion.execute(statement.bind(descuento,idProducto));
        }catch (DriverException e){
            System.out.println("Error al actualizar el descuento:"+e.getMessage());
        }
    }
    public void editarFoto(int idProducto,String foto){
        String query=String.format("UPDATE Catalogo SET foto = ? WHERE id = ?");
        try {
            PreparedStatement statement=sesion.prepare(query);
            ResultSet r=sesion.execute(statement.bind(foto,idProducto));
        }catch (DriverException e){
            System.out.println("Error al actualizar la foto:"+e.getMessage());
        }
    }
    public void editarDescripcion(int idProducto, String descripcion){
        String query=String.format("UPDATE Catalogo SET descripcion = ? WHERE id = ?");
        try {
            PreparedStatement statement=sesion.prepare(query);
            ResultSet r=sesion.execute(statement.bind(descripcion,idProducto));
        }catch (DriverException e){
            System.out.println("Error al actualizar la descripcion:"+e.getMessage());
        }
    }
}
