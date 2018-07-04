package by.it.shekh.project.java.beans;

public class User {
    Long id_users;
    String login;
    String password;
    String email;
    Long id_roles;

    public User() {

    }

    public User(Long id_users, String login, String password, String email, Long id_roles) {
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

    public Long getId() {
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

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }

    public Long getId_roles() {
        return id_roles;
    }

    public void setId_roles(Long id_roles) {
        this.id_roles = id_roles;
    }
}
