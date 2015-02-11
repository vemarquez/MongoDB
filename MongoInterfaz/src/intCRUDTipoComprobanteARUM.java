import java.sql.*;
import com.mongodb.*;



public class intCRUDTipoComprobanteARUM {
	static String[] arrDatos = new String[6];
	public static String intCreateTipoComprobanteARUM( Connection con, DB db, String sTabla ) {		
		Long lId;									
		String sError;
		
		try {
			PreparedStatement smtTipoComprobanteARUM = con.prepareStatement(intSentenciasSQL.intTipoComprobanteARUM());
			ResultSet resTipoComprobanteARUM = smtTipoComprobanteARUM.executeQuery();
			while (resTipoComprobanteARUM.next()) {				
				lId = resTipoComprobanteARUM.getLong("ID");				
				arrDatos[0] = resTipoComprobanteARUM.getString("TIPO_COMPROBANTE_AR");				
				arrDatos[1] = resTipoComprobanteARUM.getString("UNIDAD_MEDIDA");				
				arrDatos[2] = resTipoComprobanteARUM.getString("CREADO_POR");
				arrDatos[3] = resTipoComprobanteARUM.getString("FEC_CREACION");
				arrDatos[4] = resTipoComprobanteARUM.getString("MODIF_POR");
				arrDatos[5] = resTipoComprobanteARUM.getString("FEC_MODIF");
								
				sError = sCreateMDTipoComprobanteARUM( db,  sTabla, lId );
				arrDatos = new String[6];
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
	
	private static String sCreateMDTipoComprobanteARUM(DB db, String sTabla, long lId ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("tipo_comprobante_ar", arrDatos[0]);
			document.put("unidad_medida", arrDatos[1]);			
			document.put("creado_por", arrDatos[2]);
			document.put("fec_creacion", arrDatos[3]);
			document.put("modif_por", arrDatos[4]);
			document.put("modif_por", arrDatos[5]);
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
