package Service;

import Model.Producto;
import Repository.CatalogoRepository;

public class CatalogoService {
    private static CatalogoService service;
    private final CatalogoRepository repoCalogo;

    private CatalogoService(){
        this.repoCalogo=new CatalogoRepository();
    }

    public static CatalogoService getService() {
        if(service==null){
            service=new CatalogoService();
        }
        return service;
    }
    public void registrarProducto(Producto p){
        repoCalogo.nuevoProducto(p);
    }
}
