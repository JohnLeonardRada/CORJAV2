package controller;

import java.io.IOException;
import java.sql.*;

import model.*;
import view.*;

public class AbstractDemo extends BPI{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		
		Display.header();
		BPI bpi = new BPI();
		bpi.createConnection();
		
		Display.option(null, null);
		
	}
	
	
}

