package by.it.krivenkova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Runner {
    public static void main(String[] args) {
        C_Reset.resetDB();
        C_Init.initDB();
        B_AddRoles.addRoles();
        A_AddUser.addUser();
        A_AddData.addData();
        B_ShowUsers.showUsers();
    }
}
