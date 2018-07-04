package by.it.shumilov.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddOrder {
    static void add(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `Shumilov`.`orders` " +
                    "(`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) " +
                    "VALUES (1, '2018-03-11', 11, '2018-03-21', 444.4, 1, 439.96, 1, 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`orders` " +
                    "(`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) " +
                    "VALUES (2, '2018-05-26', 2, '2018-05-27', 399.8, 0, 399.8, 2, 3);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`orders` " +
                    "(`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) " +
                    "VALUES (3, '2018-06-11', 30, NULL, 4497.0, 10, 4047.3, 3, 3);");



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
