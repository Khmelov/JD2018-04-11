package by.it.zaleschonok.jd03_03.beans;

public class Users {
    private int id;
    private String login;
    private String password;
    private int roles_id;

    public Users() {
    }

    public Users(int id, String login, String password, int roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles_id = roles_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
