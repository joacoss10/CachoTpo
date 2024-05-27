package Service;

import Excepciones.CatalogoExeption;
import Model.Catalogo;
import Repository.CatalogoRepository;
public class CatalogoService {
    private static CatalogoService service;
    private final CatalogoRepository repoCalogo;

    private CatalogoService() {
        this.repoCalogo = new CatalogoRepository();
    }

    public static CatalogoService getService() {
        if (service == null) {
            service = new CatalogoService();
        }
        return service;
    }

    public void registrarProducto(Catalogo p) {
        repoCalogo.nuevoProducto(p);
    }

    public Catalogo obtenerProducto(int idProducto) throws CatalogoExeption {
        Catalogo c = repoCalogo.obtenerProducto(idProducto);
        if (c == null) {
            throw new CatalogoExeption("El producto no existe");
        } else return c;
    }
    public void editarPrecio(int idProducto,double precio){
        repoCalogo.editarPrecio(idProducto,precio);
    }
    public void editarStock(int idProducto,int stock){
       repoCalogo.editarStock(idProducto,stock);
    }
    public void editarVideo(int idProducto,String url){
        repoCalogo.editarVideo(idProducto,url);
    }
    public void editarDescuento(int idProducto,double descuento){
      repoCalogo.editarDescuento(idProducto,descuento);
    }
    public void editarFoto(int idProducto,String foto){
        repoCalogo.editarFoto(idProducto,foto);
    }
    public void editarDescripcion(int idProducto, String descripcion){
        repoCalogo.editarDescripcion(idProducto,descripcion);
    }
}
