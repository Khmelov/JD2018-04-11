package by.it.kashayed.Project.java.dao;

import by.it.kashayed.Project.java.bean.Cars;
import by.it.kashayed.Project.java.bean.Owner;
import by.it.kashayed.Project.java.bean.Owners;

import java.sql.SQLException;

public class RunnerDao {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Owners owners = new Owners(0, "TestOwner");
        dao.owners.create(owners);
        owners.setRoles("TEST");
        dao.owners.update(owners);
        dao.owners.delete(owners);
        System.out.println(owners);

        Owner owner = new Owner(0, "TestOwner", "TestOwner", "TestOwner", "TestOwner", 2);
        dao.owner.create(owner);
        owner.setName("PUPKINTEST");
        dao.owner.update(owner);
        dao.owner.delete(owner);
        System.out.println(owner);

        Cars cars = new Cars(0, "testcars", 1999, "testcars", 2.0, 1000, 2);
        cars.setModel("ModelTest");
        cars.setOwner_id(2);
        dao.cars.create(cars);
        System.out.println(cars);
        cars.setModel("NewModel");
        dao.cars.update(cars);
        dao.cars.delete(cars);
        System.out.println(cars);

        System.out.println(dao.owners.getAll(""));
        System.out.println(dao.owner.getAll(""));
        System.out.println(dao.cars.getAll(""));
    }
}
