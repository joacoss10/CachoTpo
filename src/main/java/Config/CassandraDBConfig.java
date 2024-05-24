package Config;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.DriverException;

import java.net.InetSocketAddress;

public class CassandraDBConfig {
    private static final String coneccion="localhost";
    private static final int puerto=9042;
    private static final String bd="Cacho";

    public static CqlSession getCassandra(){
        try {
            return CqlSession.builder().addContactPoint(new InetSocketAddress(coneccion, puerto))
                    .withKeyspace(bd).build();
        }catch (DriverException e){
            System.out.println("Error al conectarse a cassandra:"+e.getMessage());
            return null;
        }
    }
}
