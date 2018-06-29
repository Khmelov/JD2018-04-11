package by.it.kashayed.Project.java.dao;


import by.it.kashayed.Project.java.DBC.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DaoAbstract {
    protected int executeUpdate(String sql) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                if (1 == statement.executeUpdate(sql, 1)) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            } else return statement.executeUpdate(sql);
        }
        return 0;
    }
}
