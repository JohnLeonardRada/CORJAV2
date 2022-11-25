package view;

import java.sql.*;

public class Display {

	public static void printAllRecords(ResultSet records) throws ClassNotFoundException, SQLException{
		
		if (records != null) {
			System.out.println("ID\tAccount Number\t\tName\t\t\tBalance\n");
			while (records.next()) {
				System.out.println(records.getInt("id")+"\t"
					+records.getString("accountNumber")+"\t\t"
					+records.getString("name")+"\t"
					+records.getDouble("balance"));
			}
		} else {
			System.out.println("No records.");
		}
	}
	
	public static void printUpdatedRecord(ResultSet record) throws ClassNotFoundException, SQLException{		
		if (record != null) {
			System.out.println("ID\tAccount Number\t\tName\t\t\tBalance\n");
			while (record.next()) {
				System.out.println(record.getInt("id")+"\t"
					+record.getString("accountNumber")+"\t\t"
					+record.getString("name")+"\t"
					+record.getDouble("balance"));
			}
		} else {
			System.out.println("No records.");
		}
	}
}
