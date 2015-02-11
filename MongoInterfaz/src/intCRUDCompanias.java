import java.sql.*;
import com.mongodb.*;



public class intCRUDCompanias {
	static String[] arrDatos = new String[20];
	public static String intCreateCompanias( Connection con, DB db, String sTabla ) {		
		Long lId;		
		Long lNumero;						
	    Long lNumeroInterior;						
		String sError;
		
		try {
			PreparedStatement smtCompanias = con.prepareStatement(intSentenciasSQL.intCompanias());						
			ResultSet resCompanias = smtCompanias.executeQuery();			
			while (resCompanias.next()) {				
				lId = resCompanias.getLong("ID");				
				arrDatos[0] = resCompanias.getString("COMPANIA");				
				arrDatos[1] = resCompanias.getString("RFC");				
				arrDatos[2] = resCompanias.getString("CALLE");
				lNumero = resCompanias.getLong("NUMERO");
				lNumeroInterior = resCompanias.getLong("NUMERO_INTERIOR");
				arrDatos[3] = resCompanias.getString("COLONIA");
				arrDatos[4] = resCompanias.getString("LOCALIDAD");
				arrDatos[5] = resCompanias.getString("REFERENCIA");
				arrDatos[6] = resCompanias.getString("MUNICIPIO");
				arrDatos[7] = resCompanias.getString("ESTADO");
				arrDatos[8] = resCompanias.getString("PAIS");
				arrDatos[9] = resCompanias.getString("CODIGO_POSTAL");
				arrDatos[10] = resCompanias.getString("CREADO_POR");
				arrDatos[11] = resCompanias.getString("FEC_CREACION");
				arrDatos[12] = resCompanias.getString("MODIF_POR");
				arrDatos[13] = resCompanias.getString("FEC_MODIF");
								
				sError = sCreateMDCompanias( db,  sTabla, lId, lNumero, lNumeroInterior );
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
	
	private static String sCreateMDCompanias(DB db, String sTabla, long lId, long lNumero, long lNumeroInterior  ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("compania", arrDatos[0]);
			document.put("RFC", arrDatos[1]);
			document.put("calle", arrDatos[2] );			
			document.put("numero", lNumero);
			document.put("numero_interior", lNumeroInterior);
			document.put("colonia", arrDatos[3]);
			document.put("localidad", arrDatos[4]);
			document.put("referencia", arrDatos[5]);
			document.put("municipio", arrDatos[6]);
			document.put("estado", arrDatos[7]);
			document.put("pais", arrDatos[8]);
			document.put("codigo_postal", arrDatos[9]);			
			document.put("creado_por", arrDatos[10]);
			document.put("fec_creacion", arrDatos[11]);
			document.put("modif_por", arrDatos[12]);
			document.put("modif_por", arrDatos[13]);
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
