package model;

import java.io.*;
import java.sql.*;

public interface JDBC_SQL_METHODS {

	/*all variables are implicitly public static final*/
	String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
	String JDBC_URL = "jdbc:mysql://localhost:3306/macayan-corjav2-se21-db";
	String DB_USER_NAME = "root";
	String DB_PASSWORD = "";
	String CREATE_TABLE = "CREATE TABLE customerTransaction (" 
				                  + "ID INT AUTO_INCREMENT PRIMARY KEY," 
				                  + "NAME VARCHAR(15) NOT NULL," 
				                  + "CCNUMBER VARCHAR(16) NOT NULL," 
				                  + "PRODUCTNAME VARCHAR(15) NOT NULL,"
				                  + "PRODUCTPRICE DOUBLE NOT NULL"
				                  + ")";
	
	String INSERT_RECORD = "insert into customerTransaction ("
		+ "name, ccNumber, productName, productPrice) values (?, ?, ?, ?)";
	
	Connection createConnection() throws ClassNotFoundException, SQLException;
	boolean createTable() throws ClassNotFoundException, SQLException;
	boolean insertRecord () throws ClassNotFoundException, SQLException, IOException;
}
