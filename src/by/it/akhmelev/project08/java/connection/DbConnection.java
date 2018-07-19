package by.it.akhmelev.project08.java.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private static Connection connection;

    private DbConnection() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/my_sql_akhmelev");
            return dataSource.getConnection();
        } catch (NamingException e) {
            throw new SQLException(e);
        }
    }

//    public static Connection getConnection() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            synchronized (DbConnection.class) {
//                if (connection == null || connection.isClosed()) {
//                    connection = DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
//                }
//            }
//        }
//        return connection;
//    }


}
