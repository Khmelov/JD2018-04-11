package by.it.shekh.jd03_02;

import by.it.shekh.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RunnerTaskB {
    public static void main(String[] args) {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            System.out.println("**ALL USERS AND THEIR ROLES**");
            String sql = String.format(Locale.US,
                    "SELECT users.login, users.email, roles.role FROM " +
                            "roles join users on roles.id_roles=users.id_roles");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf("%s %s --- %s\n",
                        resultSet.getString("login"), resultSet.getString("email"), resultSet.getString("role"));
            }

            System.out.println("*****************");
            sql = "SELECT COUNT(login) FROM users;";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("Total users is: "+resultSet.getString(1)+"\n*****************");
            }
            sql="SELECT COUNT(role) from roles";
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("Total roles is: "+resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
