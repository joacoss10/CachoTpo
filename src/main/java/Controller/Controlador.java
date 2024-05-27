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
        SesionUsuarioService.getService().crearSesion(u);
        inicioSesionUsuario(dni);
    }
    public void iniciarSesion(int dni,String contraseña){
        Usuario u=null;
        try {
            u=UsuarioService.getService().loggin(dni,contraseña);
            inicioSesionUsuario(u.getDni());
        }catch (UsuarioExeption e){
            System.out.println(e.getMessage());
        }
    }
    private void inicioSesionUsuario(int dni){
        SesionUsuarioService.getService().registrarComienzoSesion(dni);
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
