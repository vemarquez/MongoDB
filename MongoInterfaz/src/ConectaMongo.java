import java.net.UnknownHostException;
import java.util.List;
 

import com.mongodb.*;
 
/**
 * Prueba para realizar conexi�n con MongoDB.
 * @author j
 *
 */
public class ConectaMongo {
    /**
     * Main del proyecto.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Prueba conexi�n MongoDB");
        MongoClient mongo = crearConexion();
 
        if (mongo != null) {
            System.out.println("Lista de bases de datos: ");
            printDatabases(mongo);
 
        } else {
            System.out.println("Error: Conexi�n no establecida");
        }
    }
 
    /**
     * Clase para crear una conexi�n a MongoDB.
     * @return MongoClient conexi�n
     */
    private static MongoClient crearConexion() {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
 
        return mongo;
    }
 
    /**
     * Clase que imprime por pantalla todas las bases de datos MongoDB.
     * @param mongo conexi�n a MongoDB
     */
    private static void printDatabases(MongoClient mongo) {
        List<String> dbs = mongo.getDatabaseNames();
        for (String db : dbs) {
            System.out.println(" - " + db);
        }
    }
}