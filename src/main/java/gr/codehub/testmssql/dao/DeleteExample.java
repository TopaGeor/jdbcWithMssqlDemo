package gr.codehub.testmssql.dao;

import gr.codehub.testmssql.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteExample {


    public static void main(String[] args) throws Exception {
        Class.forName(Constants.JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        Statement stmt = conn.createStatement();



        String sql;
        sql= "Use "+Constants.DB_SCHEMA;
        stmt.executeUpdate(sql);


        String deleteQuery = "DELETE FROM Instructor WHERE id > 0";
        System.out.println("Deleted " + stmt.executeUpdate(deleteQuery) + " rows");

        conn.close();
    }
}