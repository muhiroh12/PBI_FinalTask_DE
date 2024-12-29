package org.talend.designer.codegen.translators.databases.dbspecifics.ms_sql_server;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMSSqlRowBeginJava
{
  protected static String nl;
  public static synchronized TMSSqlRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlRowBeginJava result = new TMSSqlRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_22 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_23 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Uses an existing connection ";
  protected final String TEXT_26 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_29 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_30 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\tconn_";
  protected final String TEXT_33 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_34 = ", dbUser_";
  protected final String TEXT_35 = ", dbPwd_";
  protected final String TEXT_36 = ");" + NL + "\t\t\t";
  protected final String TEXT_37 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_38 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_39 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tif(\"com.mysql.cj.jdbc.Driver\".equals((String)globalMap.get(\"driverClass_";
  protected final String TEXT_41 = "\"))" + NL + "\t\t\t    && routines.system.BundleUtils.inOSGi()) {" + NL + "\t\t\t        Class.forName(\"com.mysql.cj.jdbc.AbandonedConnectionCleanupThread\")." + NL + "\t\t\t            getMethod(\"checkedShutdown\").invoke(null, (Object[]) null);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tconn_";
  protected final String TEXT_43 = ".setAutoCommit(";
  protected final String TEXT_44 = NL + "\t\t\t\tlog.";
  protected final String TEXT_45 = "(\"";
  protected final String TEXT_46 = " - \" + ";
  protected final String TEXT_47 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t    \t\tlog.";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_51 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_53 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_54 = ": pstmt_";
  protected final String TEXT_55 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_56 = " += (countEach_";
  protected final String TEXT_57 = " < 0 ? 0 : ";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_60 = " = \"";
  protected final String TEXT_61 = "\";" + NL + "\t\t    java.lang.Class jdbcclazz_";
  protected final String TEXT_62 = " = java.lang.Class.forName(driverClass_";
  protected final String TEXT_63 = ");" + NL + "\t\t";
  protected final String TEXT_64 = ",dbUser_";
  protected final String TEXT_65 = ",dbPwd_";
  protected final String TEXT_66 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_67 = NL + "\t\t            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_68 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t            if (null != dataSources_";
  protected final String TEXT_69 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "            \t\t\tString dsAlias_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ";" + NL + "                \t\tif (dataSources_";
  protected final String TEXT_73 = ".get(dsAlias_";
  protected final String TEXT_74 = ") == null) {" + NL + "                   \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_75 = " + \" available!\");" + NL + "                      \t}" + NL + "                \t\tconn_";
  protected final String TEXT_76 = " = dataSources_";
  protected final String TEXT_77 = ").getConnection();" + NL + "\t\t            } else {" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tString dbUser_";
  protected final String TEXT_79 = ";" + NL + "\t        " + NL + "            \t\t";
  protected final String TEXT_80 = NL + "            \t\t" + NL + "            \t\t";
  protected final String TEXT_81 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_82 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_83 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_84 = "; ";
  protected final String TEXT_85 = NL + "        \t\t   \t" + NL + "        \t        String dbPwd_";
  protected final String TEXT_86 = " = decryptedPassword_";
  protected final String TEXT_87 = ";" + NL + "\t        " + NL + "\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\tconn_";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t    }" + NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_92 = ".getAutoCommit()) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t}        " + NL + "\t\t\t\t\tint commitEvery_";
  protected final String TEXT_94 = ";" + NL + "\t\t\t\t\tint commitCounter_";
  protected final String TEXT_95 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\tString port_";
  protected final String TEXT_97 = ";" + NL + "\t\t    String dbname_";
  protected final String TEXT_98 = " ;" + NL + "\t\t    ";
  protected final String TEXT_99 = NL + "\t\t\tString url_";
  protected final String TEXT_100 = " = \"jdbc:jtds:sqlserver://\" + ";
  protected final String TEXT_101 = " ;" + NL + "\t\t\t";
  protected final String TEXT_102 = "\t\t    " + NL + "\t\t    String url_";
  protected final String TEXT_103 = " = \"jdbc:sqlserver://\" + ";
  protected final String TEXT_104 = NL + "\t\t    if (!\"\".equals(port_";
  protected final String TEXT_105 = ")) {" + NL + "\t\t    \turl_";
  protected final String TEXT_106 = " += \":\" + ";
  protected final String TEXT_107 = ";" + NL + "\t\t    }" + NL + "\t\t    if (!\"\".equals(dbname_";
  protected final String TEXT_108 = ")) {" + NL + "\t\t   \t";
  protected final String TEXT_109 = NL + "\t\t\t\turl_";
  protected final String TEXT_110 = " += \"//\" + ";
  protected final String TEXT_111 = "; " + NL + "\t\t\t";
  protected final String TEXT_112 = "\t\t    " + NL + "\t\t    \turl_";
  protected final String TEXT_113 = " += \";databaseName=\" + ";
  protected final String TEXT_114 = NL + "\t\t    }";
  protected final String TEXT_115 = NL + "                url_";
  protected final String TEXT_116 = " += \";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;Authentication=ActiveDirectoryPassword\";" + NL + "                url_";
  protected final String TEXT_117 = " += \";database=\" + ";
  protected final String TEXT_118 = ";";
  protected final String TEXT_119 = NL + "\t\t    url_";
  protected final String TEXT_120 = " += \";appName=\" + projectName + \";\" + ";
  protected final String TEXT_121 = ";" + NL + "\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\tString dbschema_";
  protected final String TEXT_123 = " = (String)globalMap.get(\"";
  protected final String TEXT_124 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_125 = ";" + NL + "\t    \t\t";
  protected final String TEXT_126 = NL + "\t\t        String  tableName_";
  protected final String TEXT_127 = " = null;" + NL + "\t\t        if(dbschema_";
  protected final String TEXT_128 = " == null || dbschema_";
  protected final String TEXT_129 = ".trim().length() == 0) {" + NL + "\t\t            tableName_";
  protected final String TEXT_130 = " = \"[\" + ";
  protected final String TEXT_131 = " + \"]\";" + NL + "\t\t        } else {" + NL + "\t\t            tableName_";
  protected final String TEXT_132 = " = \"[\" + dbschema_";
  protected final String TEXT_133 = " + \"].[\" + ";
  protected final String TEXT_134 = " + \"]\";" + NL + "\t\t        }" + NL + "\t\t        stmt_";
  protected final String TEXT_135 = ".execute(\"SET IDENTITY_INSERT \"+ tableName_";
  protected final String TEXT_136 = " +\" ON\");" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_138 = " = null;" + NL + "\tString query_";
  protected final String TEXT_139 = " = \"\";" + NL + "\tboolean whetherReject_";
  protected final String TEXT_140 = " = false;";
  protected final String TEXT_141 = NL + "        resourceMap.put(\"conn_";
  protected final String TEXT_142 = "\", conn_";
  protected final String TEXT_143 = NL + "        java.sql.PreparedStatement pstmt_";
  protected final String TEXT_144 = " = conn_";
  protected final String TEXT_145 = ".prepareStatement(";
  protected final String TEXT_146 = ");" + NL + "        resourceMap.put(\"pstmt_";
  protected final String TEXT_147 = "\", pstmt_";
  protected final String TEXT_148 = NL + "        java.sql.Statement stmt_";
  protected final String TEXT_149 = ".createStatement();" + NL + "        resourceMap.put(\"stmt_";
  protected final String TEXT_150 = "\", stmt_";
  protected final String TEXT_151 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
			connect_end();
		}
		
		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
     /* TESB-24900 - graceful shutdown for MYSQL connection */ 
    stringBuffer.append(TEXT_40);
    stringBuffer.append((connection!=null)?connection.replaceAll("'","").trim():"");
    stringBuffer.append(TEXT_41);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_36);
    
		}

		public void query(INode node, String dbQueryVariableName){
			beforeComponentProcess(node);
			//for input
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbQueryVariableName +" + \"'.");
		}

		/**
		* @deprecated please use another method instead: query(INode node, String dbQueryVariableName) because execution of the query expression can be not idempotent
		*/
		@Deprecated
		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_44);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_47);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_49);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_58);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	//this util class use by connection component
	class DefaultDBRowUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected String dbuser;
		protected String dbpwd ;
		protected String useExistingConn;
		protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;
	    
	    public void beforeComponentProcess(INode node){
	    	cid = node.getUniqueName();
	    	log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	    }
	    
	    public void afterUseExistConnection(INode node) {
	    	log4jCodeGenerateUtil.useExistConnection(node);
	    }
		
	    public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void classForName(INode node){
		
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
			newInstance(node);
		}
		
		protected void newInstance(INode node) {
			//do nothing as default
			//for sybase jdbc in java 11, we have to call jdbcclazz.newInstance method
		}
		
		public void newConnection(){
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
	 		useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	 		if(("true").equals(useExistingConn)) {
				String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				boolean isAmazonAurora = node.isVirtualGenerateNode() && (connection.matches("^.*?tAmazonAuroraConnection_\\d+$") || connection.matches("^.*?tDBConnection_\\d+$"));
				String conn = "conn_" + connection;
				if(isAmazonAurora){
				    conn += "_in";
                }
				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_49);
    
					this.afterUseExistConnection(node);
			} else {
	 			boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		 		if(specify_alias){
				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");
						
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
				}
				this.classForName(node);
				this.setURL(node);
				log4jCodeGenerateUtil.debugConnectionParams(node);
				if(needUserAndPassword) {
				
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_79);
    
            		String passwordFieldName = "__PASS__";
            		
    stringBuffer.append(TEXT_80);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    log4jCodeGenerateUtil.connect_begin();
					newConnection();
				} else {
					log4jCodeGenerateUtil.connect_begin_noUser();
				
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
				}
				log4jCodeGenerateUtil.connect_end();
				if(specify_alias){
				
    stringBuffer.append(TEXT_90);
    
				}
			}
		}

		public void setCommit(INode node){
			if(!("true").equals(useExistingConn)) {
				String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
				boolean useTransaction = !("false").equals(ElementParameterParser.getValue(node,"__USE_TRANSACTION__"));
				if(!("").equals(commitEvery) && !("0").equals(commitEvery) && useTransaction) {
				
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    log4jCodeGenerateUtil.autoCommit(node,false);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
				}
			}
		}

		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void afterConnection(INode node){
		}
	}//end DefaultDBInputUtil class
	
	DefaultDBRowUtil dbRowBeginUtil = new DefaultDBRowUtil();

    

	class DBRowBeginUtil extends DefaultDBRowUtil{
	
		private String driver;
	
		public void beforeComponentProcess(INode node){
			super.beforeComponentProcess(node);
			cid = node.getUniqueName();
			this.driver = ElementParameterParser.getValue(node, "__DRIVER__");
	    }
	    
	    public void afterUseExistConnection(INode node) {
	    	super.afterUseExistConnection(node);
	    	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String conn = "conn_" + connection;
			String schema = "dbschema_" + connection;
			INode connectionNode = null; 
			for (INode processNode : node.getProcess().getGeneratingNodes()) { 
				if(connection.equals(processNode.getUniqueName())) { 
					connectionNode = processNode; 
					break; 
				} 
			}
			driver = ElementParameterParser.getValue(connectionNode,"__DRIVER__");
	    }
	    
		public void setURL(INode node) {
            boolean useActiveDirectoryAuth = "true".equals(ElementParameterParser.getValue(node, "__ACTIVE_DIR_AUTH__"));
		
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_98);
    
			if(driver.equals("JTDS")) {
			
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_101);
    
			} else {
			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_101);
    
			}
			
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
				if(driver.equals("JTDS")) {
			
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_111);
    
				} else {
			
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_111);
    
				}
			
    stringBuffer.append(TEXT_114);
    
            if (driver.equals("MSSQL_PROP") && useActiveDirectoryAuth) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_118);
    
            }

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_121);
    
		}
		
		public String getDirverClassName(INode node){
			if(driver.equals("JTDS")) {
				return "net.sourceforge.jtds.jdbc.Driver";
			}
			return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}
		
		public void afterConnection(INode node){
			String identityInsert = ElementParameterParser.getValue(node, "__IDENTITY_INSERT__");
		    if(("true").equals(identityInsert)) {	
	    		String tableName = ElementParameterParser.getValue(node,"__TABLE__");
				boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
				if(useExistingConnection) {
					String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
					String schema = "dbschema_" + connection;
					
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_124);
    
				} else {
					String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
				    
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_125);
    
	    		}
				
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
		    }
		}
	}
	dbRowBeginUtil = new DBRowBeginUtil();

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	dbRowBeginUtil.beforeComponentProcess(node);
	log4jCodeGenerateUtil = dbRowBeginUtil.log4jCodeGenerateUtil;


    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
        dbRowBeginUtil.createConnection(node);
    
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    dbRowBeginUtil.setCommit(node);

    if (usePrepareStatement ) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(dbRowBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
    } else {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
    }
	dbRowBeginUtil.afterConnection(node);
	
    stringBuffer.append(TEXT_151);
    return stringBuffer.toString();
  }
}
