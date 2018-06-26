package by.it.krivenkova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddData {
    public static void main(String[] args) {
        addData();
    }

    public static void addData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/krivenkova" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                ""
        )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `krivenkova`.`routes` (`id`, `depTown`, `depDate`, `depTime`, `arrTown`, `price`, `numTickets`, `users_id`) " +
                    "VALUES (DEFAULT, 'Минск', '12.08.2016', '18:30', 'Москва', 15.2, 1, 2);");
            System.out.println("Route added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
