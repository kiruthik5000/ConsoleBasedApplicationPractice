package Utils.impl;

import Utils.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDatabase implements Database {
    public Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testDb", "root", "root");
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in DB"+e.getMessage());
        }
        return con;
    }
}
