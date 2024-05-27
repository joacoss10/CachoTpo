package Config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class RedisDBConfig {
    private static final String coneccion="localhost";
    private static final int puerto=6379;
    private static Jedis sesion;

    private RedisDBConfig(){}
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            cerrarConexion();
        }));
    }
    public static Jedis getRedis(){
        if(sesion==null){
            try {
               sesion=new Jedis(coneccion, puerto);
            }catch (JedisException e){
                System.out.println("Error a conectarse a redis: "+e.getMessage());
            }
        }
        return sesion;
    }
    private static void cerrarConexion(){
        if(sesion!=null){
            sesion.close();
        }
    }
}
