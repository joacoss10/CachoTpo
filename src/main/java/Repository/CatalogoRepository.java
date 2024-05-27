package Repository;

import Config.CassandraDBConfig;
import Model.Producto;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.DriverException;

public class CatalogoRepository {
    private static CqlSession sesion=null;
    private static final String tabla="Catalogo";

    public CatalogoRepository(){
        sesion= CassandraDBConfig.getCassandra();
    }
    public void nuevoProducto(Producto producto){
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
}
