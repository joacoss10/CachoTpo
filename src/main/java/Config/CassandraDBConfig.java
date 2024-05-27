package Config;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.DriverException;

import java.net.InetSocketAddress;

public class CassandraDBConfig {
    private static final String coneccion="localhost";
    private static final int puerto=9042;
    private static final String bd="Cacho";
    private static CqlSession sesion;
    private static final String localDatacenter = "datacenter1";

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            close();
        }));
    }

    private CassandraDBConfig(){}
    public static CqlSession getCassandra(){
        if(sesion==null){
            try {
                sesion= CqlSession.builder().addContactPoint(new InetSocketAddress(coneccion, puerto))
                        .withKeyspace(bd)
                        .withLocalDatacenter(localDatacenter)
                        .build();
            }catch (Exception e){
                System.out.println("Error al conectarse a cassandra:"+e.getMessage());
            }
        }
        return sesion;
    }
    private static void close() {
        if (sesion != null) {
            sesion.close();
            sesion = null;
        }
    }
}
