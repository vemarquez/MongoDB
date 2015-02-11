import java.sql.*;
import com.mongodb.*;



public class intCRUDClientes {
	static String[] arrDatos = new String[20];
	public static String intCreateClientes( Connection con, DB db, String sTabla ) {		
		Long lId;		
		Long lNumeroCliente;						
		String sError;
		
		try {
			PreparedStatement smtClientes = con.prepareStatement(intSentenciasSQL.intClientes());						
			ResultSet resClientes = smtClientes.executeQuery();

			while (resClientes.next()) {
				lId = resClientes.getLong("ID") ;
				arrDatos[0] = resClientes.getString("RFC");				
				arrDatos[1] = resClientes.getString("NOMBRE");				
				lNumeroCliente = resClientes.getLong("NUMERO_CLIENTE") ;
				arrDatos[2] = resClientes.getString("DIRECCION");
				arrDatos[3] = resClientes.getString("NUMERO");
				arrDatos[4] = resClientes.getString("NUMERO_INTERIOR");
				arrDatos[5] = resClientes.getString("COLONIA");
				arrDatos[6] = resClientes.getString("LOCALIDAD");
				arrDatos[7] = resClientes.getString("REFERENCIA");
				arrDatos[8] = resClientes.getString("MUNICIPIO");
				arrDatos[9] = resClientes.getString("ESTADO");
				arrDatos[10] = resClientes.getString("PAIS");
				arrDatos[11] = resClientes.getString("CP");
				arrDatos[12] = resClientes.getString("VAT_ID");
				arrDatos[13] = resClientes.getString("CORREO");
				arrDatos[14] = resClientes.getString("CORREO_CC");
				arrDatos[15] = resClientes.getString("CORREO_CO");
				arrDatos[16] = resClientes.getString("CREADO_POR");
				arrDatos[17] = resClientes.getString("FEC_CREACION");
				arrDatos[18] = resClientes.getString("MODIF_POR");
				arrDatos[19] = resClientes.getString("FEC_MODIF");
								
				sError = sCreateMDClientes( db,  sTabla, lId,lNumeroCliente );
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
	
	private static String sCreateMDClientes(DB db, String sTabla, long lId, long lNumeroCliente  ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("RFC", arrDatos[0]);
			document.put("Nombre", arrDatos[1]);
			document.put("NumeroCliente", lNumeroCliente);			
			document.put("direccion", arrDatos[2]);
			document.put("numero", arrDatos[3]);
			document.put("numero_interior", arrDatos[4]);
			document.put("colonia", arrDatos[5]);
			document.put("localidad", arrDatos[6]);
			document.put("referencia", arrDatos[7]);
			document.put("municipio", arrDatos[8]);
			document.put("estado", arrDatos[9]);
			document.put("pais", arrDatos[10]);
			document.put("cp", arrDatos[11]);
			document.put("vat_id", arrDatos[12]);
			document.put("correo", arrDatos[13]);
			document.put("correo_cc", arrDatos[14]);
			document.put("correo_co", arrDatos[15]);
			document.put("creado_por", arrDatos[16]);
			document.put("fec_creacion", arrDatos[17]);
			document.put("modif_por", arrDatos[18]);
			document.put("modif_por", arrDatos[19]);
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
