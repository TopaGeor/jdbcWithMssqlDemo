package gr.codehub.testmssql.mapper;

import gr.codehub.testmssql.domain.Instructor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructorMapper {

    public Instructor extractInstructor(ResultSet resultSet)
            throws SQLException {
        Instructor instructor = new Instructor();
        instructor.setId(resultSet.getInt("id"));
        instructor.setFirst(resultSet.getString("first"));
        instructor.setLast(resultSet.getString("last"));
        instructor.setAge(resultSet.getInt("age"));
        instructor.setCourse(resultSet.getString("course"));
        return instructor;
    }

}
