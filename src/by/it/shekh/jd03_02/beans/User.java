package by.it.shekh.jd03_02.beans;

public class User {
    long id_users;
    String login;
    String password;
    String email;
    long id_roles;

    public User(){

    }

    public User(long id_users, String login, String password, String email, long id_roles) {
        this.id_users = id_users;
        this.login = login;
        this.password = password;
        this.email = email;
        this.id_roles = id_roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_users +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id_roles=" + id_roles +
                '}';
    }

    public long getId() {

        return id_users;
    }

    public void setId(long id_users) {
        this.id_users = id_users;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRoles_id() {
        return id_roles;
    }

    public void setRoles_id(long id_roles) {
        this.id_roles = id_roles;
    }
}
