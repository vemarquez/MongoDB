import java.sql.*;
import com.mongodb.*;



public class intCRUDEstatusCorreoElectronico {	
	public static String intEstatusCorreoElectronico( Connection con, DB db, String sTabla ) {		
		Long lId;		
		String sValor;							    
		String sError;
		
		try {
			PreparedStatement smtEstatusCorreoElectronico = con.prepareStatement(intSentenciasSQL.intEstatusCorreoElectronico());						
			ResultSet resEstatusCorreoElectronico = smtEstatusCorreoElectronico.executeQuery();			
			while (resEstatusCorreoElectronico.next()) {				
				lId = resEstatusCorreoElectronico.getLong("ID");				
				sValor = resEstatusCorreoElectronico.getString("VALOR");																			
				sError = sCreateMDEstatusCorreoElectronico( db,  sTabla, lId, sValor );		
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
	
	private static String sCreateMDEstatusCorreoElectronico(DB db, String sTabla, long lId, String sValor ) {
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
