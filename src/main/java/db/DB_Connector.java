package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ipc_user";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    private static volatile Connection connection;

    private DB_Connector(){

    }

    public static synchronized Connection getConnection(){
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        return connection;
    }
}
