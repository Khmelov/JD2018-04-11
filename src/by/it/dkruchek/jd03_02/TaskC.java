package by.it.dkruchek.jd03_02;

import by.it.dkruchek.jd03_01.C_Init;
import by.it.dkruchek.jd03_02.beans.Employee;
import by.it.dkruchek.jd03_02.crud.CrudEmployee;
import by.it.dkruchek.jd03_02.utils.DbHelper;

import java.sql.SQLException;

public class TaskC {
    public static void main(String[] args) {
        DbHelper.dropTables();
        DbHelper.createTables();
        C_Init.main(new String[1]);
        Employee tolik = new Employee(0, "Anatoliy", "Konev",  "konev123", "konev@qwe.com",1L);
        Employee vitya = new Employee(0, "Viktor", "Ovsov",  "ovsov123", "ovsov@qwe.com",2L);
        Employee denya = new Employee(0, "Denis", "Kopytov","kopytov123", "kopytov@qwe.com",3L);
        try {
            if (CrudEmployee.create(tolik)) System.out.println("Tolik created");;
            if (CrudEmployee.create(vitya)) System.out.println("Vitya created");;
            if (CrudEmployee.create(denya)) System.out.println("Denya created");;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

