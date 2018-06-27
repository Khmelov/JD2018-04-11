package by.it.tarasiuk.jd03_03.dao;

import by.it.tarasiuk.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AbstractDao {

    long executeUpdate(String sql) throws SQLException {
        long result;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                statement.executeUpdate(sql,statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) result = generatedKeys.getLong(1);
            }
        }
        return result;
    }
}