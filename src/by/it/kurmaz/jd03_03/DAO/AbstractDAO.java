package by.it.kurmaz.jd03_03.DAO;
import by.it.kurmaz.jd03_02.connection.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO{
    long executeUpdate(String sql) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    }
                }
            } else
                return statement.executeUpdate(sql);
        }
        return 0;
    }
}
