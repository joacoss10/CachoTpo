package Service;

import Model.SesionUsuario;
import Model.Usuario;
import Repository.SesionUsuarioRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SesionUsuarioService {
    private static SesionUsuarioService service;
    private static SesionUsuarioRepository repoSesion;

    private SesionUsuarioService(){
        repoSesion=new SesionUsuarioRepository();
    }
    public static SesionUsuarioService getService(){
        if(service==null){
            service=new SesionUsuarioService();
        }
        return service;
    }
    public void registrarComienzoSesion(int dni){
        SesionUsuario sesion=repoSesion.recuperarSesion(dni);
        sesion.setInicio(calcularFechaHoraActual());
        repoSesion.registrarSesion(sesion);
    }
    public void registrarFinSesion(int dni){
        SesionUsuario s= repoSesion.recuperarSesion(dni);
        s.setCantidadDia(calcularDiasEntreFechas(s.getInicio(),s.getFin(),s.getCantidadDia()));
        s.setFin(calcularFechaHoraActual());
        s.setMinutosAcumulados(calcularDiferencia(s.getInicio(),s.getFin(),s.getMinutosAcumulados()));
        repoSesion.registrarSesion(s);
    }
    public void crearSesion(Usuario c){
        SesionUsuario sesion=new SesionUsuario();
        sesion.setApellido(c.getApellido());
        sesion.setNombre(c.getNombre());
        sesion.setDireccion(c.getDireccion());
        sesion.setKey("sesionUsuario"+Integer.toString(c.getDni()));
        sesion.setCantidadDia("1");
        sesion.setMinutosAcumulados("0");
        sesion.setInicio(calcularFechaHoraActual());
        sesion.setFin(calcularFechaHoraActual());
        repoSesion.registrarSesion(sesion);
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
    private String calcularDiferencia(String fHinicio,String fHfin,String minutos){
        int minuto=Integer.parseInt(minutos);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime inicio = LocalDateTime.parse(fHinicio, formatter);
        LocalDateTime fin = LocalDateTime.parse(fHfin, formatter);
        long diferenciaEnMinutos = Duration.between(inicio, fin).toMinutes();
        diferenciaEnMinutos+=minuto;
        return String.valueOf(diferenciaEnMinutos);
    }
    private String calcularDiasEntreFechas(String fechaInicio, String fechaFin,String cantDias) {
        int dia=Integer.parseInt(cantDias);
        String fechaI=fechaInicio.substring(0, 10);
        String fechaF=fechaFin.substring(0,10);
        if(!fechaI.equals(fechaF)){
            dia++;
        }
        return String.valueOf(dia);
    }
}
