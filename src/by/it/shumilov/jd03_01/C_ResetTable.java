package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_ResetTable {

    static void reset(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`avtos` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`orders` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Shumilov`.`passports` ;");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
