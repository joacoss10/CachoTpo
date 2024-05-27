package Service;

import Excepciones.UsuarioExeption;
import Model.SesionUsuario;
import Model.Usuario;
import Repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class UsuarioService {
    private static UsuarioService service;
    private static  UsuarioRepository repoCliente;

    private UsuarioService(){
        this.repoCliente=new UsuarioRepository();
    }
    public static UsuarioService getService(){
        if(service==null){
            service=new UsuarioService();
        }
        return service;
    }
    public void nuevoUsuario(Usuario c){
        repoCliente.registrarUsuario(c);
    }
    public void agregarPedido(int idUsuario,String idPedido){
        repoCliente.agregarPedido(idUsuario,idPedido);
    }
    public Usuario recuperarUsuario(int idUsuario) throws UsuarioExeption {
        Usuario c=repoCliente.obtenerUsuario(idUsuario);
        if (c==null){
            throw new UsuarioExeption("El usuario no existe");
        }else return c;
    }
    public Usuario loggin(int dni,String contrasenia) throws UsuarioExeption{
        Usuario c=repoCliente.obtenerUsuario(dni);
        if(c.getContrasenia().equals(contrasenia)){
            throw new UsuarioExeption("La contraseña es incorrecta");
        }else return c;
    }
    public void ActualizarCategoria(int dni, SesionUsuario sesion){
        String inicio= sesion.getInicio();
        String fin=sesion.getFin();
        int diferencia=calcularDiferencia(inicio,fin);
        String categoria;
        if(diferencia>240){
            categoria="top";
        }else if(diferencia<240 && diferencia>120){
            categoria="medium";
        }else categoria=null;
        repoCliente.actualizarCategoria(dni,categoria);
    }
    private int calcularDiferencia(String fHinicio,String fHfin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime inicio = LocalDateTime.parse(fHinicio, formatter);
        LocalDateTime fin = LocalDateTime.parse(fHfin, formatter);
        long diferenciaEnMinutos = Duration.between(inicio, fin).toMinutes();
        return (int)diferenciaEnMinutos;
    }
}
