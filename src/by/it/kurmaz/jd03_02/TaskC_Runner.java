package by.it.kurmaz.jd03_02;
import by.it.kurmaz.jd03_02.CRUD.CrudAddress;
import by.it.kurmaz.jd03_02.CRUD.CrudAdmin;
import by.it.kurmaz.jd03_02.CRUD.CrudCatalog;
import by.it.kurmaz.jd03_02.CRUD.CrudUser;
import by.it.kurmaz.jd03_02.beans.Address;
import by.it.kurmaz.jd03_02.beans.Admin;
import by.it.kurmaz.jd03_02.beans.User;
import by.it.kurmaz.jd03_03.beans.Catalog;

import java.sql.SQLException;
import java.util.Scanner;

public class TaskC_Runner {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type \"Admin\", \"User\", \"Catalog\" or \"Address\" to create an entity, or type \"end\" to exit");
        String choice;
        CrudUser crudUser = new CrudUser();
        CrudAdmin crudAdmin = new CrudAdmin();
        CrudAddress crudAddress = new CrudAddress();
        CrudCatalog catalog = new CrudCatalog();
        while (!(choice = scanner.nextLine()).equals("end")) {
            switch (choice) {
                case ("Admin"):
                    Admin admin = new Admin();
                    System.out.println("Enter a login");
                    admin.setLogin(scanner.nextLine());
                    System.out.println("Enter a password");
                    admin.setPassword(scanner.nextLine());
                    System.out.println("Enter a e-mail");
                    admin.setEmail(scanner.nextLine());
                    System.out.println("Enter phone number");
                    admin.setPhone(scanner.nextLine());
                    admin.setRoles_id(1);
                    if (crudAdmin.create(admin))
                        System.out.println("Admin created. ID number = " + admin.getId());
                    System.out.println(crudAdmin.read(admin.getId()));
                    break;
                case ("User"):
                    User user = new User();
                    System.out.println("Enter a login");
                    user.setLogin(scanner.nextLine());
                    System.out.println("Enter a password");
                    user.setPassword(scanner.nextLine());
                    System.out.println("Enter a e-mail");
                    user.setEmail(scanner.nextLine());
                    System.out.println("Enter phone number");
                    user.setPhone(scanner.nextLine());
                    user.setCarma("regular");
                    user.setRoles_id(2);
                    if (crudUser.create(user))
                        System.out.println("User created. ID number = " + user.getId());
                    System.out.println(crudUser.read(user.getId()));
                    break;

                case ("Address"):
                    Address address = new Address();
                    System.out.println("Enter a user ID to add his address");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println("You create address for a user: " + crudUser.read(index));
                    address.setUsers_id(index);
                    System.out.println("Enter a country");
                    address.setCountry(scanner.nextLine());
                    System.out.println("Enter a city");
                    address.setCity(scanner.nextLine());
                    System.out.println("Enter street");
                    address.setStreet(scanner.nextLine());
                    System.out.println("Enter building");
                    address.setBuilding(scanner.nextLine());
                    System.out.println("Enter apartment");
                    address.setApt(scanner.nextLine());
                    System.out.println("Enter ZIP");
                    address.setZip(scanner.nextLine());
                    if (crudAddress.create(address))
                        System.out.println("Address created. ID number = " + address.getId());
                    System.out.println(crudAddress.read(address.getId()));
                    break;

                case ("Catalog"):
                    Catalog cat = new Catalog();
                    System.out.println("Enter a new catalog item");
                    cat.setName(scanner.nextLine());
                    System.out.println("Enter amount");
                    cat.setAmount(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Enter a price");
                    cat.setPrice(Double.parseDouble(scanner.nextLine()));
                    if (catalog.create(cat))
                        System.out.println("Catalog Item created. ID number = " + cat.getID());
            }
            System.out.println("Type \"Admin\", \"User\" or \"Address\" to create an entity, or type \"end\" to exit");
        }
    }
}
