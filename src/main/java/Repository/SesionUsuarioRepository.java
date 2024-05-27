package Repository;

import Config.RedisDBConfig;
import Model.SesionUsuario;
import Model.Usuario;
import redis.clients.jedis.Jedis;

public class SesionUsuarioRepository {
    private static Jedis sesion=null;

    public SesionUsuarioRepository(){
        sesion= RedisDBConfig.getRedis();
    }
    public void registrarSesion(SesionUsuario s){
        String key=s.getKey();
        sesion.hset(key,"nombre",s.getNombre());
        sesion.hset(key,"apellido",s.getApellido());
        sesion.hset(key,"direccion",s.getDireccion());
        sesion.hset(key,"inicioSesion",s.getInicio());
        sesion.hset(key,"finSesion",s.getFin());
    }
    public SesionUsuario recuperarSesion(int dni){
        String key="sesionUsuario"+dni;
        SesionUsuario s=new SesionUsuario();
        s.setKey(key);
        s.setNombre(sesion.hget(key,"nombre"));
        s.setApellido(sesion.hget(key,"apellido"));
        s.setDireccion(sesion.hget(key,"direccion"));
        s.setInicio(sesion.hget(key,"inicioSesion"));
        s.setFin(sesion.hget(key,"finSesion"));
        return s;
    }
}
