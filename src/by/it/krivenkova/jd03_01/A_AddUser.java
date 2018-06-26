package by.it.krivenkova.jd03_01;

import java.sql.*;

public class A_AddUser {
    public static void main(String[] args) {

        addUser();
    }

    public static void addUser() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try(Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/krivenkova"+
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "")){

            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `krivenkova`.`users` (`id`, `login`, `password`, `surname`,`name`,`patronymic`,`email`, `roles_id`) VALUES (DEFAULT, 'admin', '123456789', 'test','test', 'administrator', 'admin@tut.by', 1);");
            System.out.println("User added.");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
