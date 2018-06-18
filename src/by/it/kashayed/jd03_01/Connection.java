package by.it.kashayed.jd03_01;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String URL ="jdbc:mysql://127.0.0.1:2016";
    private static final String USER ="root";
    private static final String PASS ="";



    public static void main(String[] args) {
        try (java.sql.Connection connection = DriverManager.getConnection(URL,USER,PASS)){
            if(!connection.isClosed()){
                System.out.println("Соединение установлено");
            }
            else {
                System.out.println("Соединение прервано");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
