package Controller;

import Model.Catalogo;
import Service.CatalogoService;
import Service.IdsService;

public class ControladorAdmin {
    private static ControladorAdmin instancia;
    private ControladorAdmin(){
        if(instancia==null){
            instancia=new ControladorAdmin();
        }
    }
    public static ControladorAdmin getInstancia() {
        return instancia;
    }
    public void nuevoProducto(String nombre,String des,double precio, int stock,String video,String foto,double descu) {
        int id= IdsService.getService().getCatalogoId();
        Catalogo b = new Catalogo(id, nombre, des, precio, stock, video, foto, descu);
        CatalogoService.getService().registrarProducto(b);
    }
    public void editarPrecio(int idProducto, double nuevoPrecio){
        CatalogoService.getService().editarPrecio(idProducto,nuevoPrecio);
    }
    public void editarDescripcion(int idProducto,String nuevaDescripcion){
        CatalogoService.getService().editarDescripcion(idProducto,nuevaDescripcion);
    }
    public void editarStock(int idProducto,int nuevoStock){
        CatalogoService.getService().editarStock(idProducto,nuevoStock);
    }
    public void editarVideo(int idProducto,String url){
        CatalogoService.getService().editarVideo(idProducto,url);
    }
    public void editarFoto(int idProducto,String foto){
        CatalogoService.getService().editarFoto(idProducto,foto);
    }
    public void asignarNuevoDescuento(int idProducto,double descuento){
        CatalogoService.getService().editarDescuento(idProducto, descuento);
    }
}
