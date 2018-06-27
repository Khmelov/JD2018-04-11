package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRole {
    static void add(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (1, 'Admin');");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (2, 'User');");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (3, 'Guest');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
