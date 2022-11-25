package model;

import java.io.*;
import java.sql.*;
import java.util.*;

import facility.*;
import utility.Reader;

public class CustomerBean implements DBOperations {
	
	private String name;
	private String ccNumber;
	private ProductBean product;
	
	public CustomerBean() {
		
	}
	
	public CustomerBean(String name, String ccNumber, ProductBean product) {
		this.name = name;
		this.ccNumber = ccNumber;
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}
	
	
	

	@Override
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		
			Connection connection = null;
			
			//Enroll the Oracle MySql JDBC Driver
			Class.forName(JDBC_DRIVER_NAME);
			
			//Create or get a Connection
			connection = DriverManager.getConnection(JDBC_URL,DB_USER_NAME, DB_PASSWORD);
			
			if (connection != null) {
				System.out.println("");
			} else {
				System.out.println("CONNECTION TO DATABASE IS INVALID");
			}
			
			return connection;
		}
	
	@Override
	public boolean insertRecord() throws ClassNotFoundException, SQLException {
		boolean isSuccess = false;
		
		Connection insert =  createConnection(); 
		
		if (insert != null) {
			//PreparedStatement Object
			PreparedStatement ptsmnt = insert.prepareStatement(INSERT_RECORD);
			
			ptsmnt.setString(1, getName());
			ptsmnt.setString(2, product.getProductName());
			ptsmnt.setDouble(3, product.getPrice());
			ptsmnt.setString(4, getCcNumber());
			
			ptsmnt.executeUpdate();			
			isSuccess = true;
		} 
		return isSuccess;
	}

	@Override
	public boolean createTable() throws ClassNotFoundException, SQLException {
		boolean isCreated = false;
		
		Connection create = createConnection();
		if (create != null) {
			//PreparedStatement Object
			PreparedStatement ptsmnt = create.prepareStatement(CREATE_TABLE);
			
			ptsmnt.executeUpdate();			
			isCreated = true;
		
		}
		return isCreated;
	}
	
	public static void readFile() throws ClassNotFoundException, SQLException, FileNotFoundException{
		
		try{
			String fileName =  "input.txt";
			
			FileInputStream fis = new FileInputStream(fileName);
			CustomerBean cb = new CustomerBean("","", new ProductBean());
			List<CustomerBean> inputList = new ArrayList<CustomerBean>();
			List<CustomerBean> inputInvalid = new ArrayList<CustomerBean>();
		
			char data;
			int temp;
			int counter = 0;
			String line = "" ;
			String line2 = "";
			
			do{
				temp = fis.read();	
				data = (char) temp;
				
				if(data == '\r'){
					++counter;
					line2 = line;
					line = "";
				}
					
				if(counter == 0){
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 1){
					cb.setName(line2);
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 2){
					cb.getProduct().setProductName(line2);
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 3){
					cb.getProduct().setPrice(Double.parseDouble(line2));
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 4){
					cb.setCcNumber(line2);
					counter = 0;
					inputList.add(cb);	
					cb = new CustomerBean(cb.getName(),cb.getCcNumber(),new ProductBean());
				}
					
			} while (temp != -1);		
				
			for(CustomerBean customer : inputList){
			
				try{
					
					System.out.println("\n\nName: " + customer.getName());
					System.out.println("Product: " + customer.getProduct().getProductName());
					System.out.println("Price: " + customer.getProduct().getPrice());
					System.out.println("CC Number: " + customer.getCcNumber());
					
					//validate....
					if(ValidateCreditCard.Validate(customer.getCcNumber()) &&
					   ValidateProductPrice.ValidatePrice(customer.product.getPrice())) {
						System.out.println("Successful Transaction!");
						customer.insertRecord();				
					}
					
					//insertrecord...
				}catch(InvalidCreditCardNumberLengthException iccnle){					
					System.out.println(iccnle.getMessage());
					System.out.println("Unsuccessful Transaction!");
					inputInvalid.add(customer);
				}catch(InvalidProductPriceException ippe) {
					System.out.println(ippe.getMessage());
					inputInvalid.add(customer);
				}
			}
			
			fis.close();
			Reader.createXMLDatabaseFile(inputInvalid);
			} catch (FileNotFoundException fnfe){
				System.out.print(fnfe.getMessage());
			} catch (IOException ioe){
				System.out.print(ioe.getMessage());
			}
		
	}
	
	public static void printRecords(){

		try{
			String fileName =  "input.txt";
			
			FileInputStream fis = new FileInputStream(fileName);
			CustomerBean cb = new CustomerBean("","", new ProductBean());
			List<CustomerBean> inputList = new ArrayList<CustomerBean>();
			List<CustomerBean> inputInvalid = new ArrayList<CustomerBean>();
		
			char data;
			int temp;
			int counter = 0;
			String line = "" ;
			String line2 = "";
			
			do{
				temp = fis.read();	
				data = (char) temp;
				
				if(data == '\r'){
					++counter;
					line2 = line;
					line = "";
				}
					
				if(counter == 0){
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 1){
					cb.setName(line2);
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 2){
					cb.getProduct().setProductName(line2);
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 3){
					cb.getProduct().setPrice(Double.parseDouble(line2));
					if(data != '\r' && data != '\n')
						line = line + data;
				}else if(counter == 4){
					cb.setCcNumber(line2);
					counter = 0;
					inputList.add(cb);	
					cb = new CustomerBean(cb.getName(),cb.getCcNumber(),new ProductBean());
				}
					
			} while (temp != -1);		
				
			for(CustomerBean customer : inputList){
			
				try{
					
					System.out.println("\n\nName: " + customer.getName());
					System.out.println("Product: " + customer.getProduct().getProductName());
					System.out.println("Price: " + customer.getProduct().getPrice());
					System.out.println("CC Number: " + customer.getCcNumber());
					
					//VALIDATION
					if(ValidateCreditCard.Validate(customer.getCcNumber()) &&
					   ValidateProductPrice.ValidatePrice(customer.product.getPrice())) {
						System.out.println("Successful Transaction!");
										
					}
					
					//INSERTION OF RECORD
				}catch(InvalidCreditCardNumberLengthException iccnle){					
					System.out.println(iccnle.getMessage());
					System.out.println("Unsuccessful Transaction!");
					inputInvalid.add(customer);
				}catch(InvalidProductPriceException ippe) {
					System.out.println(ippe.getMessage());
					inputInvalid.add(customer);
				}
			}
			
			fis.close();
			} catch (FileNotFoundException fnfe){
				System.out.print(fnfe.getMessage());
			} catch (IOException ioe){
				System.out.print(ioe.getMessage());
			}
		
	}
	
	public void assertMessage() {
		assert name == "": "Invalid!";
		assert product.getProductName() == "": "Invalid!";
		assert product.getPrice() <= 0: "Invalid!";
		assert ccNumber == "": "Invalid!";
	}

}
