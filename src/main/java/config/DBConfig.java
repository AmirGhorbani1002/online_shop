package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private static Connection connection;

    private DBConfig(){}

    public static Connection getConnection(){
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","@MIRr@9137#!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

}
