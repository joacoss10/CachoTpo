package Service;

import Model.Catalogo;
import Repository.CarritoRepository;
import Repository.SesionUsuarioRepository;

public class CarritoService {
    private static CarritoService service;
    private static CarritoRepository repoSesion;

    private CarritoService(){
        repoSesion=new CarritoRepository();
    }
    public static CarritoService getService(){
        if(service==null){
            service=new CarritoService();
        }
        return service;
    }
    public void nuevoCarrito(int dni){
        String key="Carritos:"+dni;
        repoSesion.nuevoCarrito(key);
    }
    public void agregarProducto(int dni,Catalogo c, int cantidad){
        String ultimoCarrito=repoSesion.obtenerUltimoCarrito("Carritos:"+dni);
        if(ultimoCarrito==null){
            nuevoCarrito(dni);
            ultimoCarrito=repoSesion.obtenerUltimoCarrito("Carritos:"+dni);
        }
        repoSesion.agregarProducto(c,"Carrito:"+ultimoCarrito,cantidad);
    }
}
