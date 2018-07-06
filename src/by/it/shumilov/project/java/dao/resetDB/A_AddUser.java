package by.it.shumilov.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    static void add(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `Shumilov`.`users` " +
                    "(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'admin@it.by', 1);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`users` " +
                    "(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (2, 'sas', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5', 'sas@tut.by', 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`users` " +
                    "(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (3, 'dsa', '0fe66afb0a1612d87bb0ebbb9aec28b1a7634ffbf741f9fef0fb8180823650f5', 'dima2017', 2);");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
