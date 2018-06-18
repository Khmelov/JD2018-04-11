package by.it.kurmaz.jd03_02.beans;

public class User {
    long id;
    String login;
    String password;
    String email;
    String phone;
    String carma;
    long roles_id;

    public User(long id, String login, String password, String email, String phone, String carma, long roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.carma = carma;
        this.roles_id = roles_id;
    }
}
