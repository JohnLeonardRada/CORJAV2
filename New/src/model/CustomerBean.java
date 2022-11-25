package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CustomerBean implements JDBC_SQL_METHODS {
	
	private String customerName;
	private String ccNumber;
	private ProductBean pb = new ProductBean();
	
	
	public CustomerBean() {
		this.customerName = "";
		this.ccNumber = "";
		this.pb.productName = "";
		this.pb.price = 0;
		
	}
	
	public CustomerBean(String customerName, String ccNumber, ProductBean product) {
		this.customerName = customerName;
		this.ccNumber = ccNumber;
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public ProductBean getPb() {
		return pb;
	}

	public void setPb(ProductBean pb) {
		this.pb = pb;
	}
	
	public void setProductName(String productName) {
		pb.setProductName(productName);
	}
	
	public void getProductName(String productName) {
		pb.getProductName();
	}
	
	public void setProductPrice(double productPrice) {
		pb.setPrice(productPrice);
	}
	
	public void getProductPrice(double productPrice) {
		pb.getPrice();
	}
	
	//Create Connection to Database
	public Connection createConnection() 
		throws ClassNotFoundException, SQLException {
			Connection connection = null;
						
			//enroll the Oracle MySql JDBC Driver
			Class.forName(JDBC_DRIVER_NAME);
						
			//create or get a Connection
			connection = DriverManager.getConnection(
			JDBC_URL,DB_USER_NAME, DB_PASSWORD);
						
				if (connection != null) {
					System.out.println("Connection to Database is VALID!");
				} else {
					System.out.println("Connection to Database is INVALID!");
				}
						
				return connection;
		}
	
	//this is our code with Lu on midterms
	//Insert Records to Database
	public boolean insertRecord() throws ClassNotFoundException, SQLException, IOException {
				
		boolean isSuccess = false;
				
		Connection connection =  createConnection(); 
				
			if (connection != null) {
				//PreparedStatement object
				PreparedStatement ptsmnt = connection
					.prepareStatement(INSERT_RECORD);
					
				ptsmnt.setString(1, getCustomerName());
				ptsmnt.setString(2, getCcNumber());
				ptsmnt.setString(3, pb.getProductName());
				ptsmnt.setDouble(4, pb.getPrice());
					
				ptsmnt.executeUpdate();			
				isSuccess = true;
					
			}
			return isSuccess;
		}
	
	//Assertions
	public void assertCustomerName() {
		
		assert (getCustomerName() == "") : Message.INVALID_CUSTOMER_NAME;
//		assert (getCcNumber() == "") : Message.INVALID_CREDIT_CARD_NUMBER_LENGTH;
//		assert (product.getProductName() == "") : Message.INVALID_PRODUCT_NAME;
//		assert (product.getPrice() <= 0) : Message.INVALID_PRICE;
	}
	
	public void assertCCNumber() {
		assert (getCcNumber() == "") : Message.INVALID_CREDIT_CARD_NUMBER_LENGTH;
	}
	
	public void assertProductName() {
		assert (pb.getProductName() == "") : Message.INVALID_PRODUCT_NAME;
	}
	
	public void assertProductPrice() {
		assert (pb.getPrice() <= 0) : Message.INVALID_PRICE;
	}

	//Create table in the database
	public boolean createTable() throws ClassNotFoundException, SQLException {
		Connection connection =  createConnection();
		if (connection != null) {
 			//PreparedStatement object
 			PreparedStatement ptsmnt = connection.prepareStatement(CREATE_TABLE);
 			ptsmnt.executeUpdate();

	      }     
		return false;
	}
}



