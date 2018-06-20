package by.it.kurmaz.jd03_03.DAO;
import by.it.kurmaz.jd03_03.beans.User;

public class UserDao extends UniversalDAO<User>{

    public UserDao() {
        super(new User(), "users");
    }


}
