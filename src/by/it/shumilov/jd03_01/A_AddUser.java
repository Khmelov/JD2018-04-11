package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    static void add(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `Shumilov`.`users` " +
                    "(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (1, 'admin', 'admin1', 'admin@it.by', 1);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`users` " +
                    "(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (2, 'sas', 'qwerty', 'sas@tut.by', 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`users` " +
                    "(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (3, 'dsa', 'asd12', 'dima2017', 2);");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
