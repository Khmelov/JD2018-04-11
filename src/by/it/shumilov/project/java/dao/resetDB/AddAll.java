package by.it.shumilov.project.java.dao.resetDB;

import java.sql.Connection;

public class AddAll {
    static void add(Connection connection){
        System.out.println("Add data Roles");
        B_AddRole.add(connection);
        System.out.println("Data Roles Ok");

        System.out.println("Add data Users");
        A_AddUser.add(connection);
        System.out.println("Data Users Ok");

        System.out.println("Add data Avtos");
        A_AddAvto.add(connection);
        System.out.println("Data Avtos Ok");

        System.out.println("Add data Passports");
        A_AddPassport.add(connection);
        System.out.println("Data Passports Ok");

        System.out.println("Add data Orders");
        A_AddOrder.add(connection);
        System.out.println("Data Orders Ok");
    }
}
