package model;

import java.sql.*;

public interface DBOperations {

	/*All variables are implicitly public static final*/
	String jdbcDriverName="";
	String jdbcUrl="";
	String dbUserName="";
	String dbPassword="";
	
	Connection createConnection();
	boolean insertRecord();
	ResultSet listRecords();
	
}
