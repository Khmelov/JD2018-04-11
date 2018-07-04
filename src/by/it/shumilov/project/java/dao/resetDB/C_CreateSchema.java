package by.it.shumilov.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_CreateSchema {
    static void create(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `Shumilov` DEFAULT CHARACTER SET utf8 ;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
