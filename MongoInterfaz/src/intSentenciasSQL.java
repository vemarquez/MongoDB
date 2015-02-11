public class intSentenciasSQL {
	public static String Diccionario() {
		String valor;
		valor = "SELECT lower(TABLE_NAME) TABLE_NAME " +
				"FROM USER_TABLES " +				
				"WHERE TABLE_NAME NOT IN ( 'IN_CLIENTES_TEMP','INT_CLIENTES_CARGA','INT_CLIENTES_INMOBILIARIA' " +
				",'INT_CLIENTES_RESP_19092013','INT_CLIENTES_SERVICIOS', 'INT_DIR_CLIENTES_CARGA' " +
				",'OSO', 'XX_FECHAS') " +
				"ORDER BY 1";
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

	public static String intCompanias() {
		String valor;
		valor = "SELECT ID ID " +        
				",COMPANIA COMPANIA " +         
				",RFC RFC " +             
				",CALLE CALLE " +            
				",NUMERO NUMERO " +          
				",NUMERO_INTERIOR NUMERO_INTERIOR " + 
				",COLONIA COLONIA " +         
				",LOCALIDAD LOCALIDAD " +        
				",REFERENCIA REFERENCIA " +       
				",MUNICIPIO MUNICIPIO " +        
				",ESTADO ESTADO " +           
				",PAIS PAIS " +             
				",CODIGO_POSTAL CODIGO_POSTAL " +    
				",CREADO_POR CREADO_POR " +       
				",FEC_CREACION FEC_CREACION " +    
				",MODIF_POR MODIF_POR " +        
				",FEC_MODIF FEC_MODIF " +
				"FROM INT_COMPANIAS " +
				"ORDER BY ID";
		return valor;
	}
	
	public static String intEstatusComprobantes() {
		String valor;
		valor = "SELECT ID ID " +
				",VALOR " + 
				"FROM INT_ESTATUS_COMPROBANTES " +
				"ORDER BY ID";
		return valor;
	}
	
	public static String intEstatusCorreoElectronico() {
		String valor;
		valor = "SELECT ID ID " +
				",VALOR " + 
				"FROM INT_ESTATUS_CORREO_ELECTRONICO " +
				"ORDER BY ID";
		return valor;
	}
	
	public static String intLogCargaComprobantes() {
		String valor;
		valor = "SELECT ID ID " +
				",NUMERO_COMPROBANTE NUMERO_COMPROBANTE " + 
				",TO_CHAR(FECHA_COMPROBANTE,'DD-MM-RRRR HH24:MI:SS') FECHA_COMPROBANTE " +
				",NUMERO_CLIENTE NUMERO_CLIENTE " +
				",TIPO_COMPROBANTE TIPO_COMPROBANTE " +
				",CREADO_POR CREADO_POR " +
				",TO_CHAR(FEC_CREACION,'DD-MM-RRRR HH24:MI:SS') FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",TO_CHAR(FEC_MODIF,'DD-MM-RRRR HH24:MI:SS') FEC_MODIF " +
				"FROM INT_LOG_CARGA_COMPROBANTES " +
				"ORDER BY ID";
		return valor;
	}
	public static String intSeleccionComprobantes() {
		String valor;
		valor = "SELECT ID ID " +
				",CMP_ID CMP_ID " +
				"FROM INT_SELECCION_COMPROBANTES " +
				"ORDER BY ID";
		return valor;
	}
	
	public static String intTipoComprobanteARUM() {
		String valor;
		valor = "SELECT ID ID " +
				",TIPO_COMPROBANTE_AR TIPO_COMPROBANTE_AR " +
				",UNIDAD_MEDIDA UNIDAD_MEDIDA " +
				",CREADO_POR CREADO_POR " +
				",FEC_CREACION FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",FEC_MODIF FEC_MODIF " +
				"FROM INT_TIPO_COMPROBANTE_AR_UM " +
				"ORDER BY ID ";
		return valor;
	}
	
	public static String intUserExitSystem() {
		String valor;
		valor = "SELECT ID_TAREA ID_TAREA " +
				",TAREA TAREA " +
				",TAREA_PENDIENTE TAREA_PENDIENTE " +
				",PARAMETRO1 PARAMETRO1 " +
				",PARAMETRO2 PARAMETRO2 " +
				",PARAMETRO3 PARAMETRO3 " +
				",PARAMETRO4 PARAMETRO4 " +
				",PARAMETRO5 PARAMETRO5 " +
				",PARAMETRO6 PARAMETRO6 " +
				",PARAMETRO7 PARAMETRO7 " +
				",PARAMETRO_SALIDA PARAMETRO_SALIDA" +
				",ERROR ERROR" +
				",LOG LOG " +
				"FROM  INT_USER_EXIT_SYSTEM " +
				"ORDER BY 1";
		return valor;
	}
	
	public static String intUserExitDetalleSystem() {
		String valor;
		valor = "SELECT ID_DETALLE ID_DETALLE" +
				",ID_TAREA ID_TAREA" +
				",SALIDA SALIDA " + 
				"FROM INT_USER_EXIT_DETALLE_SYSTEM " +
				"ORDER BY 1";
		return valor;
	}

	public static String intComprobantes() {
		String valor;
		valor =  "SELECT ID ID " +
				",NUMERO_COMPROBANTE NUMERO_COMPROBANTE " +
				",TO_CHAR(FECHA_COMPROBANTE,'DD-MM-RRRR HH24:MI:SS') FECHA_COMPROBANTE " +
				",NUMERO_CLIENTE NUMERO_CLIENTE " +
				",TIPO_COMPROBANTE TIPO_COMPROBANTE " +
				",MONEDA MONEDA " +
				",CODIGO_IMPUESTO CODIGO_IMPUESTO " +
				",CIA_ID CIA_ID " +
				",ECM_ID ECM_ID " +
				",ECE_ID ECE_ID " +
				",ARCHIVO_LAYOUT ARCHIVO_LAYOUT " +
				",TO_CHAR(FECHA_LAYOUT,'DD-MM-RRRR HH24:MI:SS') FECHA_LAYOUT " +
				",DIRECTORIO DIRECTORIO " +
				",ARCHIVO_FACTURA ARCHIVO_FACTURA " +
				",UUID UUID " +
				",ARCHIVO_UUID ARCHIVO_UUID " +
				",TO_CHAR(FECHA_UUID,'DD-MM-RRRR HH24:MI:SS') FECHA_UUID " +
				",DIRECTORIO_UUID DIRECTORIO_UUID " +
				",CREADO_POR CREADO_POR " +
				",TO_CHAR(FEC_CREACION,'DD-MM-RRRR HH24:MI:SS') FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",TO_CHAR(FEC_MODIF,'DD-MM-RRRR HH24:MI:SS') FEC_MODIF " +
				"FROM INT_COMPROBANTES " +
				"ORDER BY ID";
		return valor;
	}

	public static String intDetalleComprobantes() {
		String valor;
		valor = "SELECT ID ID " +
				",CANTIDAD CANTIDAD " +
				",UNIDAD UNIDAD " +
				",DESCRIPCION DESCRIPCION " +
				",PRECIO_UNITARIO PRECIO_UNITARIO " +
				",IMPORTE IMPORTE " +
				",CMP_ID CMP_ID " +
				",CREADO_POR CREADO_POR " +
				",TO_CHAR(FEC_CREACION,'DD-MM-RRRR HH24:MI:SS') FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",TO_CHAR(FEC_MODIF,'DD-MM-RRRR HH24:MI:SS') FEC_MODIF " +
				"FROM INT_DETALLE_COMPROBANTES";
		return valor;
	}
}

