package gr.codehub.testmssql.dao;

import gr.codehub.testmssql.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertExample {



    public static void main(String[] args) throws Exception {
        Class.forName(Constants.JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        Statement stmt = conn.createStatement();


        String sql;
        sql= "Use "+Constants.DB_SCHEMA;
        stmt.executeUpdate(sql);


        String query1 = "INSERT INTO Instructor (first, last, age, course) VALUES ('Chris', 'Christou', 26, 'Databases')";
        String query2 = "INSERT INTO Instructor (first, last, age, course) VALUES ('Christos', 'Christou', 35, 'I/O')";
        String query3 = "INSERT INTO Instructor (first, last, age, course) VALUES ('Spyros', 'Spyrou', 35, 'Exception Handling')";
        String query4 = "INSERT INTO Instructor (first, last, age, course) VALUES ('Grigoris', 'Grigoriou', 25, 'Threads')";
        String query5 = "INSERT INTO Instructor (first, last, age, course) VALUES ('Yiannis', 'Ioannou', 28, 'Inheritance')";
        stmt.executeUpdate(query1);
        stmt.executeUpdate(query2);
        stmt.executeUpdate(query3);
        stmt.executeUpdate(query4);
        stmt.executeUpdate(query5);

        String query6 = "INSERT INTO Instructor " +
                "(first, last, age, course) " +
                "VALUES (?,?,?,?)";

        PreparedStatement updateSales = conn.prepareStatement(query6);

        updateSales.setString(1, "Dimitris");
        updateSales.setString(2, "Iracleous");
        updateSales.setInt(3, 50);
        updateSales.setString(4, "Java spring");
        updateSales.executeUpdate();




        String queryFormat = "INSERT INTO Player (username, password) VALUES ('Spyros-%s', 'password-%s')";
        for (int i = 1; i <= 10; i++) {
            String query = String.format(queryFormat, i, i);
            stmt.executeUpdate(query);
        }


        conn.close();
    }
}