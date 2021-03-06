import java.sql.*;
import com.mongodb.*;

public class intCRUDDirList {

	public static String intCreateDirList( Connection con, DB db, String sTabla ) {
		String sError;
		String sFileName;
		String sTipo;
		try {
			PreparedStatement smtDirList = con.prepareStatement(intSentenciasSQL.intDirList());						
			ResultSet resDisList = smtDirList.executeQuery();

			while (resDisList.next()) {
				sFileName = resDisList.getString("FILENAME");
				sTipo     = resDisList.getString("TIPO");
				sError =sCreateMDDirList( db,  sTabla, sFileName, sTipo );
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

	private static String sCreateMDDirList(DB db, String sTabla, String sFileName, String sTipo) {
		String sError;
		try {
			DBCollection table = db.getCollection(sTabla);
			BasicDBObject document = new BasicDBObject();
			document.put("filename", sFileName);
			document.put("tipo", sTipo);
			table.insert(document);
		}
		catch(Exception e){
			sError = e.getClass().getName() + ": " + e.getMessage();
			return sError;
		}
		return "1";
	}


}
