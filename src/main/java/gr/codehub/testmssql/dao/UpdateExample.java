package gr.codehub.testmssql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static gr.codehub.testmssql.constants.Constants.*;

public class UpdateExample {


    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();


        String sql;
        sql= "Use "+DB_SCHEMA;
        stmt.executeUpdate(sql);



        String updateQuery = "UPDATE Instructor SET age = 30 WHERE id in (1, 6, 25)";
        System.out.println("Updated " + stmt.executeUpdate(updateQuery) + " rows");

        conn.close();
    }
}