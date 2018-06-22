package by.it.dkruchek.jd03_03.abstractdao;

import by.it.dkruchek.jd03_03.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {
    public long executeUpdate(String sql) throws SQLException {
        long result = -1;
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                    result = generatedKeys.getLong(1);
            }
        }
        return result;
    }
}