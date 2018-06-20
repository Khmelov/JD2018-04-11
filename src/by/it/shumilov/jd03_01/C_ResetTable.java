package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_ResetTable {

    static void reset(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`dbRoles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`dbUsers` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`dbAvtos` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`dbOrders` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`dbPassports` ;");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
