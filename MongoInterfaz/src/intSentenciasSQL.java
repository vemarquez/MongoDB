public class intSentenciasSQL {
	public static String Diccionario() {
		String valor;
		valor = "SELECT lower(TABLE_NAME) TABLE_NAME " +
				"FROM USER_TABLES " +
				"WHERE TABLE_NAME = 'INT_BITACORA_ENVIO_CORREOS'";
				/*"WHERE TABLE_NAME NOT IN ( 'IN_CLIENTES_TEMP','INT_CLIENTES_CARGA','INT_CLIENTES_INMOBILIARIA' " +
				",'INT_CLIENTES_RESP_19092013','INT_CLIENTES_SERVICIOS', 'INT_DIR_CLIENTES_CARGA' " +
				",'OSO', 'XX_FECHAS') " +
				"ORDER BY 1";
				'INT_CLIENTES'";*/
		return valor;
	}
	
	public static String intDirList() {
		String valor;
		valor = "SELECT FILENAME FILENAME "
				+ ", TIPO TIPO " +
                "FROM INT_DIR_LIST ";
		return valor;
	}
	
	public static String intBitacoraEnvioCorreos() {
		String valor;
		valor = "SELECT ID ID " +
				",CMP_ID CMP_ID " + 
				",TO_CHAR(FECHA,'DD-MM-RRRR HH24:MI:SS') FECHA " +
				",MENSAJE MENSAJE " +
				",CREADO_POR CREADO_POR" +
				",TO_CHAR(FEC_CREACION, 'DD-MM-RRRR HH24:MI:SS') FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",TO_CHAR (FEC_MODIF, 'DD-MM-RRRR HH24:MI:SS') FEC_MODIF " +
				"FROM INT_BITACORA_ENVIO_CORREOS " +
				"ORDER BY ID";
		return valor;
	}
	public static String intClientes() {
		String valor;
		valor = "SELECT ID ID " +
				",RFC RFC " +
				",NOMBRE NOMBRE " +
				",NUMERO_CLIENTE NUMERO_CLIENTE " +
				",DIRECCION DIRECCION " +
				",NUMERO NUMERO " +
				",NUMERO_INTERIOR NUMERO_INTERIOR " +
				",COLONIA COLONIA " +
				",LOCALIDAD LOCALIDAD " +
				",REFERENCIA REFERENCIA " +
				",MUNICIPIO MUNICIPIO " +
				",ESTADO ESTADO " +
				",PAIS PAIS " +
				",CP CP " +
				",VAT_ID VAT_ID " +
				",CORREO CORREO " +
				",CORREO_CC CORREO_CC " +
				",CORREO_CO CORREO_CO " +
				",CREADO_POR CREADO_POR " +
				",TO_CHAR(FEC_CREACION, 'DD-MM-RRRR HH24:MI:SS') FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",TO_CHAR(FEC_MODIF,'DD-MM-RRRR HH24:MI:SS') FEC_MODIF " +
				"FROM INT_CLIENTES " +
				"ORDER BY ID";
		return valor;
	}
}

