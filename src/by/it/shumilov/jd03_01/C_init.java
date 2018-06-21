package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_init {



    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {


        try ( Connection connection = DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD)){

            C_ResetSchema.reset(connection);
            System.out.println("Schema reset");

            C_CreateSchema.create(connection);
            System.out.println("Schema created");

            A_CreateTables.create(connection);
            System.out.println("Tables created");

            AddAll.add(connection);




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
