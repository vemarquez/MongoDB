import java.sql.*;
import com.mongodb.*;



public class intCRUDDetalleComprobantes {
	static String[] arrDatos = new String[7];
	public static String intCreateDetalleComprobantes( Connection con, DB db, String sTabla ) {		
		Long lId;	
		double dPrecioUnitario;
		double 	dImporte;
		Long lCmpID;		
	
		String sError;
		
		try {
			PreparedStatement smtDetalleComprobantes = con.prepareStatement(intSentenciasSQL.intDetalleComprobantes());						
			ResultSet resDetalleComprobantes = smtDetalleComprobantes.executeQuery();
			while (resDetalleComprobantes.next()) {
				lId = resDetalleComprobantes.getLong("ID") ;
				arrDatos[0] = resDetalleComprobantes.getString("CANTIDAD");				
				arrDatos[1] = resDetalleComprobantes.getString("UNIDAD");				
				arrDatos[2] = resDetalleComprobantes.getString("DESCRIPCION") ;
				dPrecioUnitario = resDetalleComprobantes.getFloat("PRECIO_UNITARIO");
				dImporte  = resDetalleComprobantes.getFloat("IMPORTE");	
				lCmpID	= resDetalleComprobantes.getLong("CMP_ID");	
				arrDatos[3] = resDetalleComprobantes.getString("CREADO_POR");
				arrDatos[4] = resDetalleComprobantes.getString("FEC_CREACION");
				arrDatos[5] = resDetalleComprobantes.getString("MODIF_POR");
				arrDatos[6] = resDetalleComprobantes.getString("FEC_MODIF");
				
				sError = sCreateMDDetalleComprobantes( db,  sTabla, lId, dPrecioUnitario, dImporte, lCmpID );
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
	
	private static String sCreateMDDetalleComprobantes(DB db, String sTabla, long lId, Double dPrecioUnitario, Double dImporte, long lCmpID  ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("cantidad", arrDatos[0]);
			document.put("unidad", arrDatos[1]);
			document.put("descripcion", arrDatos[2]);			
			document.put("precio_unitario", dPrecioUnitario);
			document.put("importe", dImporte);
			document.put("cmp_id", lCmpID);
			document.put("creado_por", arrDatos[3]);
			document.put("fec_creacion", arrDatos[4]);
			document.put("modif_por", arrDatos[5]);
			document.put("modif_por", arrDatos[6]);
		
			
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
