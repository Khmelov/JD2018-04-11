package by.it.shekh.jd03_02.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Loading driver error: " + e);
        }
    }

    private static Connection connection;

    private DbConnection(){

    }

    public static Connection getConnection() throws SQLException {
        if(connection==null || connection.isClosed()){
            synchronized (DbConnection.class){
                if (connection==null || connection.isClosed()){
                    connection=DriverManager.getConnection(CN.DB_URL,CN.DB_USER,CN.DB_PASS);
                }
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(
                             CN.DB_URL, CN.DB_USER, CN.DB_PASS);
             Statement statement=connection.createStatement();
             ) {
            statement.executeUpdate("DROP DATABASE IF EXISTS `shekh`");
            statement.executeUpdate("create database `shekh` DEFAULT CHARSET utf8");
            statement.executeUpdate("use `shekh`");
            statement.executeUpdate("CREATE TABLE `facade_general` (\n" +
                    "  `id_facade` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `facade_name` varchar(45) DEFAULT NULL,\n" +
                    "  `facade_dimensions` varchar(45) DEFAULT NULL,\n" +
                    "  `facade_description` mediumtext,\n" +
                    "  `facade_price` double DEFAULT NULL,\n" +
                    "  `facade_specs` varchar(255) DEFAULT NULL,\n" +
                    "   PRIMARY KEY(`id_facade`)" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.executeUpdate("CREATE TABLE `facade_pictures` (\n" +
                    "  `id_pictures` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `picture_path` varchar(255) DEFAULT NULL," +
                    "   PRIMARY KEY(`id_pictures`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.executeUpdate("CREATE TABLE `roles` (\n" +
                    "  `id_roles` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` varchar(45) DEFAULT 'user'," +
                    "   PRIMARY KEY(`id_roles`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.executeUpdate("CREATE TABLE `users` (\n" +
                    "  `id_users` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` varchar(45) NOT NULL,\n" +
                    "  `password` varchar(45) NOT NULL,\n" +
                    "  `email` varchar(45) NOT NULL" +
                    "   PRIMARY KEY(`id_users`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.executeUpdate("INSERT INTO `roles` (`id_roles`, `role`) VALUES\n" +
                    "(1, 'admin'),\n" +
                    "(2, 'user');");

            statement.executeUpdate("insert into `users`(login,password,email) values\n" +
                    "('user1','user1123','user1@mail.ru'),\n" +
                    "('user2','user2us11','user2@yandex.ru'),\n" +
                    "('user3','333user333','user3@gmail.com');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
