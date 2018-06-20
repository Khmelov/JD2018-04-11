package by.it.kurmaz.jd03_03.DAO;

import by.it.kurmaz.jd03_03.beans.Address;

public class AddressDao extends UniversalDAO<Address>{

    public AddressDao() {
        super(new Address(), "Address");
    }
}
