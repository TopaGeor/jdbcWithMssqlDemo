package gr.codehub.testmssql.dao;

import gr.codehub.testmssql.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(Constants.JDBC_DRIVER);

        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS)) {
            try (Statement stmt = conn.createStatement()) {
                conn.setAutoCommit(false);


                String sql;
                sql= "Use "+Constants.DB_SCHEMA;
                stmt.executeUpdate(sql);



                String query1 = "INSERT INTO Instructor (id, first, last, age, course) VALUES (1000, 'Chris', 'Gavanas', 26, 'Databases')";
                String query2 = "INSERT INTO Instructor (id, first, last, age, course) VALUES (1001, 'Christos', 'Peristeris', 35, 'I/O')";
                String query3 = "INSERT INTO Instructor (id, first, last, age, course) VALUES (1002, 'Spyros', 'Argyroiliopoulos', 35, 'Exception Handling')";
                String query4 = "INSERT INTO Instructor (id, first, last, age, course) VALUES (1003, 'Grigoris', 'Dimopoulos', 25, 'Threads')";
                String query5 = "INSERT INTO Instructor (id, first, last, age, course) VALUES (1004, 'Yiannis', 'Vlahopoulos', 28, 'Inheritance')";
                stmt.executeUpdate(query1);
                stmt.executeUpdate(query2);
                stmt.executeUpdate(query3);
                stmt.executeUpdate(query4);
                stmt.executeUpdate(query5);

                conn.commit();
            } catch (SQLException e) {
                if (conn != null) {
                    // we need to catch the SQLException
                    // that happens during query executions
                    // in order to command the DB to rollback
                    conn.rollback();
                }
            }
        } catch (SQLException e) {
            // when is this going to be called?
            e.printStackTrace();
        }
    }

}
