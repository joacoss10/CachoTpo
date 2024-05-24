package Config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class RedisDBConfig {
    private static final String coneccion="localhost";
    private static final int puerto=9042;

    public static Jedis getRedis(){
        try {
            return new Jedis(coneccion, puerto);
        }catch (JedisException e){
            System.out.println("Error a conectarse a redis: "+e.getMessage());
            return null;
        }
    }
}
