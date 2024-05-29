package Repository;

import Config.RedisDBConfig;
import Excepciones.CarritoExeption;
import Model.Catalogo;
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
    public void agregarProducto(Catalogo c,String clave,int cantidad){
        //sesion.hset(key,"nombre",s.getNombre());
        try {
            sesion.hget(clave,String.valueOf(c.getId()));
            sesion.hget(clave,c.getNombre());
            sesion.hget(clave,String.valueOf(c.getPrecio()));
            sesion.hget(clave,String.valueOf(cantidad));
            sesion.hget(clave,String.valueOf(c.getDescuento()));
        }catch (JedisException e){
            System.out.println("Error al guardar el producto: "+e.getMessage());
        }
    }
    public String obtenerUltimoCarrito(String clave) {
        String ultimo=null;
        try{
            String firstElement = sesion.lindex(clave, 0);
        }catch (JedisException e){
            System.out.println("Error al recuperar carrito"+e.getMessage());
        }
        return ultimo;
    }
}
