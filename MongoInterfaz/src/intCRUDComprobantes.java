import java.sql.*;
import com.mongodb.*;



public class intCRUDComprobantes {
	static String[] arrDatos = new String[18];
	public static String intCreateComprobantes( Connection con, DB db, String sTabla ) {		
		Long lId;							
		Long lCiaId;		
		Long lEcmId;		
		Long lEceId;		
		String sError;
		
		try {
			PreparedStatement smtComprobantes = con.prepareStatement(intSentenciasSQL.intComprobantes());						
			ResultSet resComprobantes = smtComprobantes.executeQuery();
			while (resComprobantes.next()) {
				lId = resComprobantes.getLong("ID") ;
				arrDatos[0] = resComprobantes.getString("NUMERO_COMPROBANTE");				
				arrDatos[1] = resComprobantes.getString("FECHA_COMPROBANTE");				
				arrDatos[2] = resComprobantes.getString("NUMERO_CLIENTE") ;
				arrDatos[3] = resComprobantes.getString("TIPO_COMPROBANTE");
				arrDatos[4] = resComprobantes.getString("MONEDA");
				arrDatos[5] = resComprobantes.getString("CODIGO_IMPUESTO");
				lCiaId = resComprobantes.getLong("CIA_ID") ;
				lEcmId = resComprobantes.getLong("ECM_ID") ;
				lEceId = resComprobantes.getLong("ECE_ID") ;
				arrDatos[6] = resComprobantes.getString("ARCHIVO_LAYOUT");
				arrDatos[7] = resComprobantes.getString("FECHA_LAYOUT");
				arrDatos[8] = resComprobantes.getString("DIRECTORIO");
				arrDatos[9] = resComprobantes.getString("ARCHIVO_FACTURA");
				arrDatos[10] = resComprobantes.getString("UUID");
				arrDatos[11] = resComprobantes.getString("ARCHIVO_UUID");
				arrDatos[12] = resComprobantes.getString("FECHA_UUID");				
				arrDatos[13] = resComprobantes.getString("DIRECTORIO_UUID");				
				arrDatos[14] = resComprobantes.getString("CREADO_POR");
				arrDatos[15] = resComprobantes.getString("FEC_CREACION");
				arrDatos[16] = resComprobantes.getString("MODIF_POR");
				arrDatos[17] = resComprobantes.getString("FEC_MODIF");
				
				sError = sCreateMDComprobantes( db,  sTabla, lId, lCiaId, lEcmId, lEceId );
				arrDatos = new String[18];
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
	
	private static String sCreateMDComprobantes(DB db, String sTabla, long lId, long lCiaId, long lEcmId, long lEceId  ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("numero_comprobante", arrDatos[0]);
			document.put("fecha_comprobante", arrDatos[1]);
			document.put("numero_cliente", arrDatos[2]);			
			document.put("tipo_comprobante", arrDatos[3]);
			document.put("moneda", arrDatos[4]);
			document.put("codigo_impuesto", arrDatos[5]);
			document.put("cia_id", lCiaId);
			document.put("ecm_id", lEcmId);
			document.put("ece_id", lEceId);
			document.put("archivo_layout", arrDatos[6]);
			document.put("fecha_layout", arrDatos[7]);
			document.put("directorio", arrDatos[8]);
			document.put("archivo_factura", arrDatos[9]);
			document.put("uuid", arrDatos[10]);
			document.put("archivo_uuid", arrDatos[11]);
			document.put("fecha_uuid", arrDatos[12]);
			document.put("directorio_uuid", arrDatos[13]);
			document.put("creado_por", arrDatos[14]);
			document.put("fec_creacion", arrDatos[15]);
			document.put("modif_por", arrDatos[16]);
			document.put("modif_por", arrDatos[17]);
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
