package Repository;

import Config.RedisDBConfig;
import redis.clients.jedis.Jedis;

public class IdRepositorio {
    private static Jedis sesion;
    public IdRepositorio(){
        sesion=RedisDBConfig.getRedis();
    }
    public int getCatalogoId(){
        String key="Catalogo";
        String valor=sesion.get(key);
        int nuevoValor=Integer.valueOf(valor);
        nuevoValor++;
        sesion.set(key,String.valueOf(nuevoValor));
        return nuevoValor;
    }
}
