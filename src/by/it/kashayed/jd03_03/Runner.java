package by.it.kashayed.jd03_03;

import by.it.kashayed.jd03_03.bean.Cars;
import by.it.kashayed.jd03_03.bean.Owner;
import by.it.kashayed.jd03_03.bean.Owners;
import by.it.kashayed.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Owners owners = new Owners(0,"TestOwner");
        dao.owners.create(owners);
        owners.setOwners("TEST");
        dao.owners.update(owners);
        dao.owners.delete(owners);
        System.out.println(owners);

        Owner owner = new Owner(0,"TestOwner","TestOwner","TestOwner",2);
        dao.owner.create(owner);
        owner.setName("PUPKINTEST");
        dao.owner.update(owner);
        dao.owner.delete(owner);
        System.out.println(owner);

        Cars cars = new Cars();
        cars.setModel("ModelTest");
        cars.setOwner_id(1);
        dao.cars.create(cars);
        cars.setModel("NewModel");
        dao.cars.update(cars);
        dao.cars.delete(cars);
        System.out.println(cars);

        System.out.println(dao.owners.getAll(""));
        System.out.println(dao.owner.getAll(""));
        System.out.println(dao.cars.getAll(""));
    }
}
