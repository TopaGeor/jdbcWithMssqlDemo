package gr.codehub.testmssql.dao;

import gr.codehub.testmssql.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionExample {



    public static void main(String[] args) throws Exception {
        Class.forName(Constants.JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        Statement stmt = conn.createStatement();

        String query = "SELECT first, last, age, course FROM Instructor where age > '%s'";

        Scanner sc = new Scanner(System.in);

        ResultSet rs = stmt.executeQuery(String.format(query, sc.nextLine()));
        while (rs.next()) {
            System.out.println(rs.getString("first") + " " + rs.getString("last") + " " + rs.getInt("age") + " " + rs.getString("course"));
        }

//        10000' UNION ALL SELECT username as first, password as last, id as age, password as course FROM Player --
//        PreparedStatement preparedStatement = conn.prepareStatement("SELECT first, last, age, course FROM Instructor where age > ?");
//        preparedStatement.setString(1, sc.nextLine());
//        ResultSet rs = preparedStatement.executeQuery();
//        while (rs.next()) {
//            System.out.println(rs.getString("first") + " " + rs.getString("last") + " " + rs.getInt("age") + " " + rs.getString("course"));
//        }

    }

}
