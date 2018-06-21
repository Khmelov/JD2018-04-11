package by.it.rogov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

        //static block to load driver( best method, but not mandatory if run from idea)
        static {
            try{
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Error loading driver:" + e);;
            }
        }

        public static void main(String[] args) {

            try(Connection connection =
                        DriverManager.getConnection
                                (CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
                Statement statement=connection.createStatement()) {

                //drop schema if exist
                statement.executeUpdate("DROP SCHEMA IF EXISTS `rogov`");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}
