package by.it.kurmaz.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class Orderlist_Init {
    static void createOrders(Connection connection) {
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `kurmaz`.`Orders` (`ID`, `Cost`, `Completed`, `Users_ID`) VALUES (DEFAULT, 10, FALSE, 1);");
            statement.executeUpdate("INSERT INTO `kurmaz`.`Orders` (`ID`, `Cost`, `Completed`, `Users_ID`) VALUES (DEFAULT, 15, TRUE, 2);");
            statement.executeUpdate("INSERT INTO `kurmaz`.`Orders` (`ID`, `Cost`, `Completed`, `Users_ID`) VALUES (DEFAULT, 25, FALSE, 3);");
            statement.executeUpdate("INSERT INTO `kurmaz`.`Orders` (`ID`, `Cost`, `Completed`, `Users_ID`) VALUES (DEFAULT, 35, FALSE, 1);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
