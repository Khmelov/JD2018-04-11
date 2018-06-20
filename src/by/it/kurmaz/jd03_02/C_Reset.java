package by.it.kurmaz.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {
    static void reset (Connection connection) {
        System.out.println("Deleting tabs");
        try(Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`ShippingList`");
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`Catalog`");
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`Orders`");
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`Address`");
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`Users`");
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`Admins`");
            statement.execute("DROP TABLE IF EXISTS `kurmaz`.`Roles`");
            statement.execute("DROP SCHEMA IF EXISTS `kurmaz` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Delete successfull");
    }
}
