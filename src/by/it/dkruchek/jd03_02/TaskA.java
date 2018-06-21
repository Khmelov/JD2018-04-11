package by.it.dkruchek.jd03_02;

import by.it.dkruchek.jd03_02.beans.Employee;
import by.it.dkruchek.jd03_02.crud.CrudEmployee;

import java.sql.*;

public class TaskA {
    public static void main(String[] args) throws SQLException {
        CrudEmployee crud = new CrudEmployee();
        Employee testEmployee = new Employee(
                0,
                "TestUserName",
                "TestUserLastname",
                "TestUserPassword",
                "TestUserEmail",
                2L);
        if (crud.create(testEmployee))
            System.out.println("Create "+testEmployee);
        testEmployee=crud.read(testEmployee.getId());
        if (testEmployee!=null)
            System.out.println("Read "+testEmployee);
        testEmployee.setEmail("NewEmail");
        if (crud.update(testEmployee))
            System.out.println("Update "+testEmployee);
        if (crud.delete(testEmployee))
            System.out.println("Delete "+testEmployee);

    }
}
