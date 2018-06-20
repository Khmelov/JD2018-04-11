package by.it.dkruchek.jd03_02;

import by.it.dkruchek.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {


    try (
    Connection connection = DBConnection.getConnection();
    Statement statement = connection.createStatement();
    ){
        System.out.println("--ALL EMPLOYEES--");
        String sql = "SELECT employees.name, employees.lastname, roles.role FROM employees JOIN roles ON employees.roles_id=roles.id";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.printf("%s %s -- %s\n",resultSet.getString("lastname"),resultSet.getString("name"),resultSet.getString("role"));
        }
        System.out.println("-----------------");
        sql = "SELECT COUNT(*) FROM employees";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Total number of employees: " + resultSet.getString(1));        }
        sql = "SELECT COUNT(*) FROM roles";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Total number of roles: " + resultSet.getString(1));        }
    } catch (SQLException e) {
         e.printStackTrace();
    }
    }
}
