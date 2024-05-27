package Service;

import Model.SesionUsuario;
import Model.Usuario;
import Repository.SesionUsuarioRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SesionUsuarioService {
    private static SesionUsuarioService service;
    private static SesionUsuarioRepository repoSesion;

    private SesionUsuarioService(){}
    public static SesionUsuarioService getService(){
        if(service==null){
            service=new SesionUsuarioService();
        }
        return service;
    }
    public void registrarComienzoSesion(Usuario u){
        SesionUsuario sesion=crearSesion(u);
        sesion.setInicio(calcularFechaHoraActual());
        sesion.setFin("0");
        repoSesion.registrarSesion(sesion);
    }
    public void registrarFinSesion(int dni){
        SesionUsuario s= repoSesion.recuperarSesion(dni);
        s.setFin(calcularFechaHoraActual());
        repoSesion.registrarSesion(s);
    }
    private SesionUsuario crearSesion(Usuario c){
        SesionUsuario sesion=new SesionUsuario();
        sesion.setApellido(c.getApellido());
        sesion.setNombre(c.getNombre());
        sesion.setDireccion(c.getDireccion());
        sesion.setKey("sesioUsuario"+Integer.toString(c.getDni()));
        return sesion;
    }
    private String calcularFechaHoraActual(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = fechaHoraActual.format(formatter);
        return fechaHora;
    }
    public SesionUsuario obetenerSesion(int dni){
        return repoSesion.recuperarSesion(dni);
    }
}
