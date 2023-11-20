package MainPackage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingleConnexion {
	
    private static Connection connection = null;

    private SingleConnexion() {
    	Properties properties = new Properties() ;

        // Load the properties file
        try (FileInputStream input = new FileInputStream("path/to/your/database.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String dbUrl = properties.getProperty("db");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        
        String url = "jdbc:mysql://localhost/" + dbUrl;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Instance Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        if (connection == null)
            new SingleConnexion();
        return connection;
    }
}
