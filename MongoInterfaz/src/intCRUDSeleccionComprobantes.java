import java.sql.*;
import com.mongodb.*;



public class intCRUDSeleccionComprobantes {	
	public static String intSeleccionComprobantes( Connection con, DB db, String sTabla ) {		
		Long lId;		
		Long lCMP_Id;							    
		String sError;
		
		try {
			PreparedStatement smtSeleccionComprobantes = con.prepareStatement(intSentenciasSQL.intSeleccionComprobantes());						
			ResultSet resSeleccionComprobantes = smtSeleccionComprobantes.executeQuery();			
			while (resSeleccionComprobantes.next()) {				
				lId = resSeleccionComprobantes.getLong("ID");				
				lCMP_Id = resSeleccionComprobantes.getLong("CMP_ID");																			
				sError = sCreateMDSeleccionComprobantes( db,  sTabla, lId, lCMP_Id );		
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
	
	private static String sCreateMDSeleccionComprobantes(DB db, String sTabla, long lId, long lCMP_Id ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("cmp_id", lCMP_Id);								
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
