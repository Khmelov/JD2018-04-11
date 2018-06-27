package by.it.kashayed.jd03_02;

public class User {

    long id;
    String login;
    String email;
    String password;
    String name;
    long owners_id;

    public User(long id, String login, String email, String password, String name, long owners_id) {
    }

    public User(long id, String login, String email, String password, long roles_id) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.owners_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public long getRoles_id() {
        return owners_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", roles_id=" + owners_id +
                '}';
    }
}
