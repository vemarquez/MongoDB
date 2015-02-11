import java.sql.*;
import com.mongodb.*;



public class intCRUDLogCargaComprobantes {
	static String[] arrDatos = new String[8];
	public static String intCreateLogCargaComprobantes( Connection con, DB db, String sTabla ) {		
		Long lId;									
		String sError;
		
		try {
			PreparedStatement smtLogCargaComprobantes = con.prepareStatement(intSentenciasSQL.intLogCargaComprobantes());
			ResultSet resLogCargaComprobantes = smtLogCargaComprobantes.executeQuery();
			while (resLogCargaComprobantes.next()) {				
				lId = resLogCargaComprobantes.getLong("ID");				
				arrDatos[0] = resLogCargaComprobantes.getString("NUMERO_COMPROBANTE");				
				arrDatos[1] = resLogCargaComprobantes.getString("FECHA_COMPROBANTE");
				arrDatos[2] = resLogCargaComprobantes.getString("NUMERO_CLIENTE");		
				arrDatos[3] = resLogCargaComprobantes.getString("TIPO_COMPROBANTE");
				arrDatos[4] = resLogCargaComprobantes.getString("CREADO_POR");
				arrDatos[5] = resLogCargaComprobantes.getString("FEC_CREACION");
				arrDatos[6] = resLogCargaComprobantes.getString("MODIF_POR");
				arrDatos[7] = resLogCargaComprobantes.getString("FEC_MODIF");
								
				sError = sCreateMDLogCargaComprobantes( db,  sTabla, lId );
				arrDatos = new String[20];
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
	
	private static String sCreateMDLogCargaComprobantes(DB db, String sTabla, long lId ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("numero_comprobante", arrDatos[0]);
			document.put("fecha_comprobante", arrDatos[1]);
			document.put("numero_cliente", arrDatos[2] );			
			document.put("tipo_comprobante", arrDatos[3]);		
			document.put("creado_por", arrDatos[4]);
			document.put("fec_creacion", arrDatos[5]);
			document.put("modif_por", arrDatos[6]);
			document.put("modif_por", arrDatos[7]);
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
