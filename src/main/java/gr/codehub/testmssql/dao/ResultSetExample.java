package gr.codehub.testmssql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import gr.codehub.testmssql.domain.Instructor;

import static gr.codehub.testmssql.constants.Constants.*;


public class ResultSetExample {


    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();

        List<Instructor> instructors = new LinkedList<>();

        String sql;
        sql= "Use "+DB_SCHEMA;
        stmt.executeUpdate(sql);


        String query = "SELECT * FROM Instructor";
        ResultSet resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            Instructor instructor = new Instructor();
            instructor.setId(resultSet.getInt("id"));
            instructor.setFirst(resultSet.getString("first"));
            instructor.setLast(resultSet.getString("last"));
            instructor.setAge(resultSet.getInt("age"));
            instructor.setCourse(resultSet.getString("course"));
            instructors.add(instructor);
        }

        conn.close();

        for (Instructor instructor : instructors) {
            System.out.println(instructor.toString());
        }
    }
}
