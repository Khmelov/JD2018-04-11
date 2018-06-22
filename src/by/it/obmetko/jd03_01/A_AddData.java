package by.it.obmetko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class A_AddData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/obmetko",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "insert into buyers(Login,Password,Email,roles_id)" +
                            " values('admin3','admin3','admin2@mail.ru',1);"
            );
            statement.executeUpdate(
                    "insert into buyers(Login,Password,Email,Roles_id)" +
                            " values('user','rhretu','user@tut.by',2);"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

