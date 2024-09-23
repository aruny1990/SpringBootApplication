package com.RegistrationApp.demo.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseTesting {

	public static void main(String[] args) {
String url = "jdbc:sqlserver://DESKTOP-8UST9F6:3306;databaseName=myUser;authenticationScheme=NTLM;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        
        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
