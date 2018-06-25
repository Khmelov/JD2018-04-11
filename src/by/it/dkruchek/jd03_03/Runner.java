package by.it.dkruchek.jd03_03;

import by.it.dkruchek.jd03_03.beans.Employee;
import by.it.dkruchek.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        List<Employee> employeeAll= dao.employee.getAll("");
        for (Employee employee1 : employeeAll) {
            System.out.println(employee1);
        }
        Employee employee = new Employee(0, "Roma", "lol", "lol", "12344", 2L);
        dao.employee.create(employee);
        System.out.println(dao.employee.read(employee.getId()).getName());
        System.out.println(dao.role.read(employee.getRole_id()).getRole());
        employee.setName("Vikentiy");
        dao.employee.update(employee);
        System.out.println(dao.employee.read(employee.getId()).getName());
        dao.employee.delete(employee);
    }
}
