package by.it.zaleschonok.jd03_02;

import by.it.zaleschonok.jd03_01.C_Init;
import by.it.zaleschonok.jd03_02.connection.DbConnection;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {
    public static void main(String[] args) {

        C_Init.createDB();
        dellAllTables();

    }



    public static void dellAllTables(){

        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            statement.execute("DROP TABLE IF EXISTS `orders`");
            statement.execute("DROP TABLE IF EXISTS `goods`");
            statement.execute("DROP TABLE IF EXISTS `users`");
            statement.execute("DROP TABLE IF EXISTS `roles`");
            System.out.println("All tables removed");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

