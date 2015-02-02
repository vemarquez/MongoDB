import java.sql.*;
import java.sql.Connection;
import com.mongodb.*;
import java.io.*;


public class CreateCollections {

	public static String[] leeArchivo() {
		
		String[] Conexion = new String[]{"","","","",""};
		int v_contador = 1;

		try{			 			
			FileInputStream fstream = new FileInputStream("c:\\MongoDB\\ConexionOracle\\conecta_oracle.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine; 
			
			while ((strLine = br.readLine()) != null) {
				if ( v_contador == 1)
					Conexion[0] = strLine;
				else if ( v_contador == 2)
					Conexion[1] = strLine;
				else if ( v_contador == 3)
					Conexion[2] = strLine;
				else if ( v_contador == 4)
					Conexion[3] = strLine;
				else if ( v_contador == 5)
					Conexion[4] = strLine;
				v_contador++;
			}
			in.close();

		} catch (Exception e){			

			System.err.println("Error: " + e.getMessage());
		}
		return Conexion;
	}

	public static Connection conOracle = null;

	public static void main(String[] args) {

		String connoracle[] = new String[9];
		String StrInterfaz = "interfaz";
		String sTabla;
		long lContador = 1;
		DB db = null;
		MongoClient mongoClient = null;
		DBCollection Tabla;
		DBCollection getTabla;

		connoracle = leeArchivo();                

		conOracle = intConectaOracle.connOrcl(connoracle[0], connoracle[1], connoracle[2] , connoracle[3], connoracle[4]);

		if(conOracle != null) {
			System.out.println("Conectado a oracle");
			try{   
				// To connect to mongodb server
				mongoClient = new MongoClient( "localhost" , 27017 );
				// Now connect to your databases
				db = mongoClient.getDB( StrInterfaz );
				System.out.println("Connect to database successfully la base de datos es " + StrInterfaz );
			} catch(Exception e)
			{
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			}

			try {
				PreparedStatement smtDiccionario = conOracle.prepareStatement(intSentenciasSQL.Diccionario());
				ResultSet resDiccionario = smtDiccionario.executeQuery();
				while (resDiccionario.next()) {
					sTabla = resDiccionario.getString("TABLE_NAME");
					System.out.println(  lContador +". Tabla Oracle " + sTabla);
					lContador++;
					try {
						Tabla = db.createCollection(sTabla, null);
						System.out.println("Tabla Creada " + Tabla);
						getTabla = db.getCollection(sTabla);
						System.out.println("Tabla " + getTabla + " seleccionada" );
                        if (sTabla.equals("int_dir_list")) {
                        	intCRUDDirList.intCreateDirList(conOracle, db, sTabla);                        	
                        }
                        else if (sTabla.equals("int_bitacora_envio_correos")) {
                        	intCRUDBitacoraEnvioCorreos.intCreateBitacoraEnvioCorreos(conOracle, db, sTabla);
                        }
                        else if (sTabla.equals("int_clientes")) {
                        	intCRUDClientes.intCreateClientes(conOracle, db, sTabla);
                        }

						/*BasicDBObject document1 = new BasicDBObject();
						document1.put("filename", "paso");
						document1.put("tipo", "archivo");
						getTabla.insert(document1);*/

					}
					catch(Exception e){
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					}
				}

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
}



