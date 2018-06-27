package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddAvto {
    static void add(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `Shumilov`.`avtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) " +
                    "VALUES (1, 'VW', 'Pasat B6', 'Black', '1A2S3D4F5G6H7J8K9', 2012, '1234 SW-5', 40.4, default);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`avtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) " +
                    "VALUES (2, 'Porshe', '911', 'Red', '1A2S3D4F5G6H7J8KY', 2017, '5432 AD-4', 199.9,  default);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`avtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) " +
                    "VALUES (3, 'Infiniti', 'p40', 'White', '1A2S3D4F5G6H7J8FD', 2015, '8888 BO-7', 149.9,  default);");




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
