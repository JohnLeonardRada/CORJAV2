package model;

import java.sql.*;

public interface DBOperations {

	String JDBC_DRIVER_NAME="com.mysql.jdbc.Driver";
	String JDBC_URL="jdbc:mysql://localhost:3306/rada-sanjuan-mp-finals-corjav2-seg21-db";
	String DB_USER_NAME="root";
	String DB_PASSWORD="";
	
	String CREATE_TABLE = "CREATE TABLE bankDb ("
			+ "ID int Auto_Increment Primary Key,"
			+ "CustomerName VARCHAR(50) NOT NULL,"
			+ "ProductName VARCHAR(50),"
			+ "ProductPrice DOUBLE NOT NULL,"
			+ "CcNumber VARCHAR(20) NOT NULL)";
	
	String INSERT_RECORD = "INSERT INTO bankDb " + "(CustomerName, ProductName, ProductPrice, CcNumber) VALUES (?, ?, ?, ?)";
	
	Connection createConnection() throws ClassNotFoundException, SQLException;
	boolean createTable() throws ClassNotFoundException, SQLException;
	boolean insertRecord() throws ClassNotFoundException, SQLException;
		
}
