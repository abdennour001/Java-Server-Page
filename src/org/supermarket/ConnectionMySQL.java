package org.supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    public static Connection connection=null;

    private static final String HOST="localhost";
    private static final String USER="root";
    private static final String PASSWORD="";
    private static final String BDD="supermarket";

    public ConnectionMySQL() {

    }

    public static void connectToDataBase() throws SQLException {
        System.out.println("connection...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/"+BDD+"?"+
                "user=" + USER + "&password=" + PASSWORD );
        System.out.println("connected.");
    }

    public static void closeConnexion() throws SQLException {
        connection.close();
    }

    public static String getBDD() {
        return BDD;
    }
}
