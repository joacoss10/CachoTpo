package Repository;

import Config.RedisDBConfig;
import Model.SesionUsuario;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class SesionUsuarioRepository {
    private static Jedis sesion;

    public SesionUsuarioRepository(){
        sesion= RedisDBConfig.getRedis();
    }
    public void registrarSesion(SesionUsuario s){
        String key=s.getKey();
        try {
            sesion.hset(key,"nombre",s.getNombre());
            sesion.hset(key,"apellido",s.getApellido());
            sesion.hset(key,"direccion",s.getDireccion());
            sesion.hset(key,"inicioSesion",s.getInicio());
            sesion.hset(key,"finSesion",s.getFin());
            sesion.hset(key,"cantidadDias",s.getCantidadDia());
            sesion.hset(key,"cantidadMinutos",s.getMinutosAcumulados());
        }catch (JedisException e){
            System.out.println("Error al registrar la sesion: "+e.getMessage());
        }

    }
    public SesionUsuario recuperarSesion(int dni){
        String key="sesionUsuario"+dni;
        SesionUsuario s=new SesionUsuario();
        s.setKey(key);
        try {
            s.setNombre(sesion.hget(key, "nombre"));
            s.setApellido(sesion.hget(key, "apellido"));
            s.setDireccion(sesion.hget(key, "direccion"));
            s.setInicio(sesion.hget(key, "inicioSesion"));
            s.setFin(sesion.hget(key, "finSesion"));
            s.setMinutosAcumulados(sesion.hget(key, "cantidadMinutos"));
            s.setCantidadDia(sesion.hget(key, "cantidadDias"));
        }catch (JedisException e){
            System.out.println("Error al recuperar la sesion: "+e.getMessage());
        }
        return s;
    }
}
