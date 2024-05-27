package Repository;

import Config.RedisDBConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class CarritoRepository {
    private static Jedis sesion;

    public CarritoRepository(){
        sesion= RedisDBConfig.getRedis();
    }
    public void nuevoCarrito(String key){
        try {
            long valorActual=sesion.llen(key);
            valorActual++;
            sesion.lpush(key,String.valueOf(valorActual));
        }catch (JedisException e){
            System.out.println("Error al crear el carrito"+e.getMessage());
        }
    }
}
