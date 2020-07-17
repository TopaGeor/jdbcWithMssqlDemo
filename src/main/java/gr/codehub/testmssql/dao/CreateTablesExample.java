package gr.codehub.testmssql.dao;

import gr.codehub.testmssql.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTablesExample {


    public static void main(String[] args) throws Exception {
        Class.forName(Constants.JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        Statement stmt = conn.createStatement();

        String sql;
        sql = "Use " + Constants.DB_SCHEMA;
        stmt.executeUpdate(sql);

        sql = "DROP TABLE IF EXISTS Instructor";

        stmt.executeUpdate(sql);

        sql = "DROP TABLE IF EXISTS Player";

        stmt.executeUpdate(sql);

        sql = "create table Instructor (" +
                "id int PRIMARY KEY IDENTITY(1,1) , " +
                "first nVARCHAR(255), " +
                "last nVARCHAR(255), " +
                "age INT, " +
                "course nVARCHAR(255) )";

        stmt.executeUpdate(sql);

        sql = "create table Player (" +
                "id int  PRIMARY KEY IDENTITY(1,1), " +
                "username nVARCHAR(255), " +
                "password nVARCHAR(255) )";

        stmt.executeUpdate(sql);

        conn.close();
    }
}