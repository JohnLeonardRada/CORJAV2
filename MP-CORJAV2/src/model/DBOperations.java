package model;

import java.sql.*;

public interface DBOperations {

	/*all variables are implicitly public static final*/
	String JDBC_DRIVER_NAME="com.mysql.jdbc.Driver";
	String JDBC_URL="jdbc:mysql://localhost:3306/rada-sanjuan-corjav2-seg21-db";
	String DB_USER_NAME="root";
	String DB_PASSWORD="";
	
	//Performs DML statements
	String TABLE = "SELECT * FROM bankAccount";
	String INSERT_RECORD = "INSERT INTO bankAccount " + "(name, balance, accountNumber) VALUES (?, ?, ?)";
	String SEARCH_RECORD = "SELECT accountNumber, balance from bankAccount where accountNumber = ?";
	String BALANCE_INQUIRY = "SELECT accountNumber, balance FROM banking WHERE accountNumber = ?";
	String LIST_ALL_RECORDS = "SELECT * FROM bankAccount";
	String WITHDRAW = "UPDATE INTO bankAccount SET balance = balance - ? WHERE accountNumber = ? ";
	String DELETE_RECORD = "DELETE FROM bankAccount WHERE accountNumber = ?";
	
	Connection createConnection() throws ClassNotFoundException, SQLException;
	ResultSet table() throws ClassNotFoundException, SQLException;
	boolean insertRecord() throws ClassNotFoundException, SQLException;
	boolean searchRecord() throws ClassNotFoundException, SQLException;
	ResultSet balanceRecord() throws ClassNotFoundException, SQLException;
	ResultSet listRecord() throws ClassNotFoundException, SQLException;
	boolean withdrawRecord() throws ClassNotFoundException, SQLException;
	boolean deleteRecord() throws ClassNotFoundException, SQLException;
	
}

