package by.it.rogov.jd03_03.utiles;


import by.it.rogov.jd03_03.connection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    public static void dropTables() throws SQLException {

        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){

            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate("DROP TABLE IF EXISTS `roles`");
            statement.executeUpdate("DROP TABLE IF EXISTS `users`");
            statement.executeUpdate("DROP TABLE IF EXISTS `biblioteca`");
            statement.executeUpdate("DROP TABLE IF EXISTS `user_biblioteca`");
            System.out.println("Drop All Table");
        }

    }

}
