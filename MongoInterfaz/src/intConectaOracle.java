import java.sql.*;
import oracle.jdbc.driver.OracleDriver;

/**
 * Clase Principal de conexión a la instancia oracle version 11.2 XE 
 * Hace referencia a la libreria Estándar ojdbc5.jar para la vesion 11g de Oracle
 */

public class intConectaOracle {

	/** 
	 * Clase Principal de conexión a la instancia oracle version 11.2 XE 
	 * Hace referencia a la libreria Estándar ojdbc5.jar para la vesion 11g de Oracle
	 * @author Víctor Márquez Flores, para ONOSIT, S.A. de C.V.
     * @since 2 de noviembre, 2011
	 * @param ip Direccion del servidor que alberga la instancia Oracle
	 * @param puerto Puerto de conexion hacia la base de datos Oracle
	 * @param sid Nombre de instancia de la base de datos
	 * @param usr Usuario de base de datos
	 * @param pwd Contraseña
	 * @return Connection Una clase con la instacia Oracle para ejecutar operacions DDL y DML. Si hay error de conexión regresa valor NULO. 
	 */

  public static Connection connOrcl(String ip, String puerto, String sid, String usr, String pwd)
  {
      Connection con = null;
      String conexion = (new StringBuilder("jdbc:oracle:thin:@")).append(ip).append(":"+puerto+":").append(sid).append(",").append(usr).append(",").append(pwd).toString();
      System.out.println(conexion);
      try
      {
          DriverManager.registerDriver(new OracleDriver());
      }
      catch(Exception ex)
      {
          System.out.println("No se pudo connectar al driver de oracle");
          System.out.println(ex.getMessage());
          return null;
      }
      try
      {
          con = DriverManager.getConnection((new StringBuilder("jdbc:oracle:thin:@")).append(ip).append(":").append(puerto).append(":").append(sid).toString(), usr, pwd);
          return con;
      }
      catch(SQLException sqe)
      {
          System.out.println("No se pudo conectar a oracle");
          System.out.println(sqe.getMessage());
          return null;
      }
  }
}
