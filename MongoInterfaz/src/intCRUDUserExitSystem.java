import java.sql.*;
import com.mongodb.*;



public class intCRUDUserExitSystem {
	static String[] arrDatos = new String[12];
	public static String intCreateUserExitSystem( Connection con, DB db, String sTabla ) {		
		Long lId;									
		String sError;
		
		try {
			PreparedStatement smtUserExitSystem = con.prepareStatement(intSentenciasSQL.intUserExitSystem());
			ResultSet resUserExitSystem = smtUserExitSystem.executeQuery();
			while (resUserExitSystem.next()) {				
				lId = resUserExitSystem.getLong("ID_TAREA");				
				arrDatos[0] = resUserExitSystem.getString("TAREA");				
				arrDatos[1] = resUserExitSystem.getString("TAREA_PENDIENTE");				
				arrDatos[2] = resUserExitSystem.getString("PARAMETRO1");				
				arrDatos[3] = resUserExitSystem.getString("PARAMETRO2");
				arrDatos[4] = resUserExitSystem.getString("PARAMETRO3");
				arrDatos[5] = resUserExitSystem.getString("PARAMETRO4");
				arrDatos[6] = resUserExitSystem.getString("PARAMETRO5");
				arrDatos[7] = resUserExitSystem.getString("PARAMETRO6");
				arrDatos[8] = resUserExitSystem.getString("PARAMETRO7");
				arrDatos[9] = resUserExitSystem.getString("PARAMETRO_SALIDA");
				arrDatos[10] = resUserExitSystem.getString("ERROR");
				arrDatos[11] = resUserExitSystem.getString("LOG");;
								
				sError = sCreateMDUserExitSystem( db,  sTabla, lId );
				arrDatos = new String[12];
				if( ! sError.equals("1"))
					return sError;				
			}
		}
		catch(SQLException sqe)
		{
			System.out.println( sqe.getMessage());
			return sqe.getMessage();
		}
		return "0";
	}
	
	private static String sCreateMDUserExitSystem(DB db, String sTabla, long lId ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id_tarea", lId);
			document.put("tarea", arrDatos[0]);
			document.put("tarea_pendiente", arrDatos[1]);			
			document.put("parametro1", arrDatos[2]);
			document.put("parametro2", arrDatos[3]);
			document.put("parametro3", arrDatos[4]);
			document.put("parametro4", arrDatos[5]);
			document.put("parametro5", arrDatos[6]);
			document.put("parametro6", arrDatos[7]);
			document.put("parametro7", arrDatos[8]);
			document.put("parametro_salida", arrDatos[9]);
			document.put("error", arrDatos[10]);
			document.put("log", arrDatos[11]);
			
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
