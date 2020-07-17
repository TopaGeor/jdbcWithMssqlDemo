package gr.codehub.testmssql.dao;

import gr.codehub.testmssql.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(Constants.JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(Constants.DB_BASE_URL,
                Constants.USER, Constants.PASS);
        Statement stmt = conn.createStatement();

        String sql1= "Use Master";
        stmt.executeUpdate(sql1);

        String sql2 = "IF DB_ID('"+Constants.DB_SCHEMA+"') IS NOT NULL\n" +
                "begin\n" +
                "\talter database ["+Constants.DB_SCHEMA+"] set single_user with rollback immediate\n" +
                "\tdrop database ["+Constants.DB_SCHEMA+"]\n" +
                "end\n"  ;
        stmt.executeUpdate(sql2);

        String sql3 = "create database ["+Constants.DB_SCHEMA+"] ";
        stmt.executeUpdate(sql3);

        String sql4= "Use " + Constants.DB_SCHEMA;
        stmt.executeUpdate(sql4);

        conn.close();
    }
}
