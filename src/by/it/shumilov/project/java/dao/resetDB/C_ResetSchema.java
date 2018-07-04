package by.it.shumilov.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_ResetSchema {
    static void reset(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `Shumilov` ;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
