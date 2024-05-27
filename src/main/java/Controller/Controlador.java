package Controller;

import Excepciones.UsuarioExeption;
import Model.SesionUsuario;
import Model.Usuario;
import Service.SesionUsuarioService;
import Service.UsuarioService;

public class Controlador {
    public void registrarUsuario(int dni,String nombre,String apellido,String direccion,String contraseña){
        Usuario u=new Usuario(dni,nombre,apellido,direccion,contraseña);
        UsuarioService.getService().nuevoUsuario(u);
    }
    public void iniciarSesion(int dni,String contraseña){
        Usuario u=null;
        try {
            u=UsuarioService.getService().loggin(dni,contraseña);
        }catch (UsuarioExeption e){
            System.out.println(e.getMessage());
        }
        inicioSesionUsuario(u);
    }
    private void inicioSesionUsuario(Usuario u){
        SesionUsuarioService.getService().registrarComienzoSesion(u);
    }
    public void cerrarSesion(int dni){
        SesionUsuarioService.getService().registrarFinSesion(dni);
        actualizarCategoria(dni);
    }
    private void actualizarCategoria(int dni){
        SesionUsuario sesion=SesionUsuarioService.getService().obetenerSesion(dni);
        UsuarioService.getService().ActualizarCategoria(dni,sesion);
    }
}
