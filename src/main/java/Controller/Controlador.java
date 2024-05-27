package Controller;

import Excepciones.CatalogoExeption;
import Excepciones.UsuarioExeption;
import Model.Catalogo;
import Model.SesionUsuario;
import Model.Usuario;
import Service.CarritoService;
import Service.CatalogoService;
import Service.SesionUsuarioService;
import Service.UsuarioService;
import View.UsuarioView;

public class Controlador {
    private static Controlador instancia;
    private static int user;

    private Controlador(){}
    public static Controlador getInstancia(){
        if(instancia==null){
            instancia=new Controlador();
        }
        return instancia;
    }
    public void registrarUsuario(int dni,String nombre,String apellido,String direccion,String contraseña){
        Usuario u=new Usuario(dni,nombre,apellido,direccion,contraseña);
        UsuarioService.getService().nuevoUsuario(u);
        SesionUsuarioService.getService().crearSesion(u);
        inicioSesionUsuario(dni);
    }
    public boolean iniciarSesion(int dni,String contraseña){
        Usuario u=null;
        try {
            u=UsuarioService.getService().loggin(dni,contraseña);
            user=u.getDni();
            inicioSesionUsuario(user);
        }catch (UsuarioExeption e){
            System.out.println(e.getMessage());
        }
        return u != null;
    }
    private void inicioSesionUsuario(int dni){
        SesionUsuarioService.getService().registrarComienzoSesion(dni);
    }
    public void cerrarSesion(){
        SesionUsuarioService.getService().registrarFinSesion(user);
        actualizarCategoria();
    }
    private void actualizarCategoria(){
        SesionUsuario sesion=SesionUsuarioService.getService().obetenerSesion(user);
        UsuarioService.getService().ActualizarCategoria(user,sesion);
    }
    public UsuarioView mostrarUsuario(){
        try {
            Usuario u = UsuarioService.getService().recuperarUsuario(user);
            return u.UsuarioToView();
        }catch (UsuarioExeption e){
            e.getMessage();
            return null;
        }
    }
    public void nuevoProducto(int id,String nombre,String des,double precio, int stock,String video,String foto,double descu) {
        Catalogo b = new Catalogo(id, nombre, des, precio, stock, video, foto, descu);
        CatalogoService.getService().registrarProducto(b);
    }
    public void actualizarPrecio(int idProducto, double nuevoPrecio){
        CatalogoService.getService().editarPrecio(idProducto,nuevoPrecio);
    }
    public void editarDescripcion(int idProducto,String nuevaDescripcion){
        CatalogoService.getService().editarDescripcion(idProducto,nuevaDescripcion);
    }
    public void nuevoCarrito(){
        CarritoService.getService().nuevoCarrito(user);
    }
    public void agregarProducto(int idProducto){
        try {
            Catalogo c = CatalogoService.getService().obtenerProducto(idProducto);
        }catch (CatalogoExeption e){
            System.out.println(e.getMessage());
        }
    }



}
