package by.it.kashayed.Project.CRUD;

public class User{

    long id;
    String login;
    String email;
    String password;
    String name;
    long owners_id;

    public User() {
    }

    public User(long id, String login, String email, String password, String name, long owners_id) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.owners_id = owners_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwners_id() {
        return owners_id;
    }

    public void setOwners_id(long owners_id) {
        this.owners_id = owners_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", owners_id=" + owners_id +
                '}';
    }
}
