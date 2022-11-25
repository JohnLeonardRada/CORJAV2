/*package model;

import java.sql.*;

public interface DBOperations {

	/*all variables are implicitly public static final*/
	//String JDBC_DRIVER_NAME="com.mysql.jdbc.Driver";
	//String JDBC_URL="jdbc:mysql://localhost:3306/rada-corjav2-seg21-db";
	//String DB_USER_NAME="root";
	///String DB_PASSWORD="";
	
	//Performs DML statements
	//String INSERT_RECORD = "insert into bpicustomer (" + "name, balance, accountNumber) values( ?, ?, ?)";
	//String LIST_ALL_RECORDS = "select from bpicustomer";
	//String UPDATE_RECORD = "update bpi customer(" + "name, balance, accountNumber) values( ?, ?, ?)";
	//String DELETE_RECORD = "delete data record (" + "name, balance, accountNumber) values( null, 0, null)";
	
	
	//Connection createConnection() throws ClassNotFoundException, SQLException;
	//boolean insertRecord() throws ClassNotFoundException, SQLException;
	//ResultSet listRecords()throws ClassNotFoundException, SQLException;
	//boolean updateRecord() throws ClassNotFoundException, SQLException;
	//boolean deleteRecord() throws ClassNotFoundException, SQLException;

//}*/

package model;

import java.sql.*;

public interface DBOperations {

	/*all variables are implicitly public static final*/
	String JDBC_DRIVER_NAME="com.mysql.jdbc.Driver";
	String JDBC_URL="jdbc:mysql://localhost:3306/rada-corjav2-seg21-db";
	String DB_USER_NAME="root";
	String DB_PASSWORD="";
	
	//perform DML statements
	String INSERT_RECORD = "insert into bpicustomer ("
		+ "name, balance, accountNumber) values (?, ?, ?)";
	
	String LIST_ALL_RECORDS = "sElecT * fRom BPIcusTomeR";
	
	//hands-on exercise
	//String UPDATE_RECORD = "need sql statement here";
	//String DELETE_RECORD = "need sql statement here";
	
	Connection createConnection() throws ClassNotFoundException, SQLException;
	boolean insertRecord() throws ClassNotFoundException, SQLException;
	ResultSet listRecords() throws ClassNotFoundException, SQLException;
	
	//boolean updateRecord() throws ClassNotFoundException, SQLException;
	//boolean deleteRecord() throws ClassNotFoundException, SQLException;
}

