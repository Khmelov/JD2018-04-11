package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddPassport {
    static void add(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbPassports` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `dbUsers_id`) " +
                    "VALUES (1, 'Aleks', 'State', '866534435908896RB7', '375771234567', 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbPassports` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `dbUsers_id`) " +
                    "VALUES (2, 'Dmitrii', 'Amenko', '854352754324123RB3', '375227654323', 3);");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
