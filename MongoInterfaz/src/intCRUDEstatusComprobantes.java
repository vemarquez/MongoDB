import java.sql.*;
import com.mongodb.*;



public class intCRUDEstatusComprobantes {	
	public static String intEstatusComprobantes( Connection con, DB db, String sTabla ) {		
		Long lId;		
		String sValor;							    
		String sError;
		
		try {
			PreparedStatement smtEstatusComprobantes = con.prepareStatement(intSentenciasSQL.intEstatusComprobantes());						
			ResultSet resEstatusComprobantes = smtEstatusComprobantes.executeQuery();			
			while (resEstatusComprobantes.next()) {				
				lId = resEstatusComprobantes.getLong("ID");				
				sValor = resEstatusComprobantes.getString("VALOR");																			
				sError = sCreateMDEstatusComprobantes( db,  sTabla, lId, sValor );		
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
	
	private static String sCreateMDEstatusComprobantes(DB db, String sTabla, long lId, String sValor ) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("id", lId);
			document.put("valor", sValor);								
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}

}
