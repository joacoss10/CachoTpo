package Config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class RedisDBConfig {
    private static final String coneccion="localhost";
    private static final int puerto=9042;
    private static Jedis sesion;

    private RedisDBConfig(){}
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
}
