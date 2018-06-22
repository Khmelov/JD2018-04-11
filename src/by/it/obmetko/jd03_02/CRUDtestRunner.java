package by.it.obmetko.jd03_02;

import by.it.obmetko.jd03_02.crud.Buyer;
import by.it.obmetko.jd03_02.crud.BuyerCRUD;

import java.sql.SQLException;

public class CRUDtestRunner {
    public static void main(String[] args) throws SQLException {
        BuyerCRUD buyerCRUD = new BuyerCRUD();
        Buyer testUser = new Buyer(
                0,
                "TestUser",
                "TestUser",
                "TestUser",
                2);
        if (buyerCRUD.create(testUser))
            System.out.println("Create " + testUser);
        testUser = buyerCRUD.read(testUser.getId());
        if (testUser != null)
            System.out.println("Read " + testUser);
        testUser.setEmail("NewEmail");
        if (buyerCRUD.update(testUser))
            System.out.println("Update " + testUser);
        if (buyerCRUD.delete(testUser))
            System.out.println("Delete " + testUser);

    }
}