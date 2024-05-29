package Controller;

import Excepciones.CatalogoExeption;
import Excepciones.UsuarioExeption;
import Model.Catalogo;
import Model.SesionUsuario;
import Model.Usuario;
import Service.*;
import View.UsuarioView;

public class ControladorUsuario {
    private static ControladorUsuario instancia;
    private static int user;

    private ControladorUsuario(){}
    public static ControladorUsuario getInstancia(){
        if(instancia==null){
            instancia=new ControladorUsuario();
        }
        return instancia;
    }
    public void registrarUsuario(int dni,String nombre,String apellido,String direccion,String contraseña){
        Usuario u=new Usuario(dni,nombre,apellido,direccion,contraseña);
        UsuarioService.getService().nuevoUsuario(u);
        SesionUsuarioService.getService().crearSesion(u);
        inicioSesionUsuario(dni);
        user=dni;
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

    public void nuevoCarrito(){
        CarritoService.getService().nuevoCarrito(user);
    }
    public void agregarProducto(int idProducto,int cantidad){
        try {
            Catalogo c = CatalogoService.getService().obtenerProducto(idProducto);
            CarritoService.getService().agregarProducto(user,c,cantidad);
        }catch (CatalogoExeption e){
            System.out.println(e.getMessage());
        }
    }

}
